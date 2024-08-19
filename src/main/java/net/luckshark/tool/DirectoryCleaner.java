package net.luckshark.tool;

import java.io.File;

public class DirectoryCleaner {
    public static void directoryCleaner(String directoryPath) {
        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            boolean result = deleteContents(directory);
            if (result) {
                System.out.println("Cleaner: " + directory.getAbsolutePath());
            } else {
                System.out.println("Cleaner error: " + directory.getAbsolutePath());
            }
        } else {
            System.out.println("inexistence: " + directory.getAbsolutePath());
        }
    }
    public static boolean deleteContents(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteContents(file);
                }
                if (!file.delete()) {
                    return false;
                }
            }
        }
        return true;
    }
}