package com.potapova.bankProject.service;

import com.potapova.bankProject.exception.EmptyDirectoryException;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatalogAnalyser {
    public List<File> getFiles(File f) {
        List<File> filesList = new ArrayList<>();
        if (f.isDirectory()) {
            File file = new File(String.valueOf(f));
            File[] arrayOfFiles = file.listFiles();
            if (arrayOfFiles != null) {
                filesList = Arrays.asList(arrayOfFiles);
            } else {
                throw new EmptyDirectoryException("The file is empty");
            }
        }
        return getTxtFiles(filesList);
    }

    public List<File> getTxtFiles(List<File> fl) {
        List<File> txtFilesList = new ArrayList<>();
        for (File f : fl) {
            if (f.getName().endsWith(".txt")) {
                txtFilesList.add(f);
            }
        }
        return txtFilesList;
    }

    public static String resultCatalogParsingTest(File file, List<File> listTxt) {
        if (listTxt.contains(file)) {
            return "Success";
        } else {
            return "Unsuccessfully";
        }
    }
}
