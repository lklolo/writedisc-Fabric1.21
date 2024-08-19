package net.luckshark.gentools;

import java.io.FileWriter;
import java.io.IOException;

public class GenFabricItemGroup {
    public  static void gen(String filename, String upperCaseName , String filePath){

        String contentToAppend = "fabricItemGroupEntries.add(ADISC_MUSIC_DISC_" + upperCaseName + ");\n";

        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            fileWriter.write(contentToAppend);
            System.out.println("Write successful!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
