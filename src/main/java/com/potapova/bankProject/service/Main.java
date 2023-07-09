package com.potapova.bankProject.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BalanceTransfers balanceTransfers = new BalanceTransfers();
        CatalogAnalyser catalogAnalyser = new CatalogAnalyser();
        ReportProcessor reportProcessor = new ReportProcessor();
        ArchiveSender archiveSender = new ArchiveSender();
        HashMap<String, Integer> accountBalanceMap = balanceTransfers.readAccountBalance(new File("src/main/java/com/potapova/bankProject/files/AccountBalance.txt"));
        System.out.println(accountBalanceMap);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an operation number: ");
        int operationNumber = scanner.nextInt();
        List<File> txtFilesList;
        if (operationNumber == 1) {
            txtFilesList = catalogAnalyser.getFiles(new File("src/main/java/com/potapova/bankProject/files/BankTransfers"));
            balanceTransfers.readTransfersFiles(txtFilesList, accountBalanceMap);
            reportProcessor.writeReport(new File("src/main/java/com/potapova/bankProject/files/Report.txt"), new File("src/main/java/com/potapova/bankProject/files/BankTransfers"), txtFilesList);
            balanceTransfers.rewriteBalance(new File("src/main/java/com/potapova/bankProject/files/AccountBalance.txt"), accountBalanceMap);
            archiveSender.sendToArchive(txtFilesList, "src/main/java/com/potapova/bankProject/files/Archive");
        } else if (operationNumber == 2) {
            System.out.println(reportProcessor.readReport(new File("src/main/java/com/potapova/bankProject/files/Report.txt")));
        } else {
            System.out.println("Wrong operation number");
        }
        }
    }