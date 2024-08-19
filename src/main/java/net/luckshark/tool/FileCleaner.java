package net.luckshark.tool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCleaner {
    public static void fileCleaner(String filePath) {
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            try (FileWriter fileWriter = new FileWriter(file)) {
                System.out.println("Cleaner: " + file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("inexistence :" + file.getAbsolutePath());
        }
    }
}

