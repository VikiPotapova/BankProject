package com.potapova.bankProject.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class ReportProcessor {
    public void writeReport(File fileForWrite, File catalog, List<File> listTxt) {
        try (FileWriter fileWriterReport = new FileWriter(fileForWrite, true)) {
            for (File f : Objects.requireNonNull(catalog.listFiles())) {
                fileWriterReport.write(LocalDateTime.now() + " | " + f.getName() + " | " + CatalogAnalyser.resultCatalogParsingTest(f, listTxt) + "\n");
                fileWriterReport.flush();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public String readReport(File file) throws IOException {
        BufferedReader bufferedReaderReport = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = bufferedReaderReport.readLine()) != null) {
            result.append(line);
            result.append("\n");
        }
        bufferedReaderReport.close();
        return result.toString();
    }
}
