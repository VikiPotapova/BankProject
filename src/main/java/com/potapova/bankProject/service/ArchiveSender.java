package com.potapova.bankProject.service;

import java.util.List;
import java.io.File;

public class ArchiveSender {
    public void sendToArchive(List<File> list, String pathDestination) {
        for (File f : list) {
            f.renameTo(new File(pathDestination + "/" + f.getName()));
        }
    }
}