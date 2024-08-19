package net.luckshark.gentools;

import java.io.FileWriter;
import java.io.IOException;

public class GenJukeboxsongs2 {
    public  static void gen(String filename, String upperCaseName, double doubleDuration, String filePath){

        String contentToAppend = "RegistryKey<JukeboxSong> ADISC_" + upperCaseName + " = of(\"adisc_" + filename + "\");\n";

        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            fileWriter.write(contentToAppend);
            System.out.println("Write successful!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
