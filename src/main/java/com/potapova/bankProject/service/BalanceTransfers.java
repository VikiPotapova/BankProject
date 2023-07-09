package com.potapova.bankProject.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalanceTransfers {
    public HashMap <String, Integer> readAccountBalance(File file) {
        HashMap <String, Integer> accountBalanceMap = new HashMap<>();
        try (BufferedReader bufferedFileReaderBalance = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = bufferedFileReaderBalance.readLine()) != null) {
                if (line.matches("\\d{5}\\-\\d{5}\\s+\\d+")) {
                    String[] array = line.split("\\s+");
                    accountBalanceMap.put( array[0], Integer.parseInt(array[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accountBalanceMap;
    }

    public void readTransfersFiles(List<File> list, HashMap<String, Integer> map) {
        for (File f : list) {
            try (BufferedReader bufferedFileReaderTransfers = new BufferedReader(new FileReader(f))) {
                String line1;
                while ((line1 = bufferedFileReaderTransfers.readLine()) != null) {
                    if (line1.matches("\\d{5}\\-\\d{5}\\|\\d{5}\\-\\d{5}\\|\\d+")) {
                        String[] array1 = line1.split("\\|");
                        if (map.get(array1[0]) > map.get(array1[1])) {
                            map.put(array1[0], map.get(array1[0]) - Integer.parseInt(array1[2]));
                            map.put(array1[1], map.get(array1[1]) + Integer.parseInt(array1[2]));
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void rewriteBalance(File file, HashMap<String, Integer> map) {
        try (FileWriter fileRewriterBalance = new FileWriter(file)) {
            for (Map.Entry entry : map.entrySet()) {
                fileRewriterBalance.write(entry.getKey() + " " + entry.getValue() + "\n");
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}