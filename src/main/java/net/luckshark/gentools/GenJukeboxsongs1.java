package net.luckshark.gentools;

import java.io.FileWriter;
import java.io.IOException;

public class GenJukeboxsongs1 {
    public  static void gen(String filename, String upperCaseName, double doubleDuration, String filePath){

        int duration = (int) doubleDuration;

        String contentToAppend = "register(registry, ADISC_" + upperCaseName + ", ModSoundEvents.ADISC_MUSIC_DISC_" + upperCaseName + ", "+ duration + ", 15);\n";

        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            fileWriter.write(contentToAppend);
            System.out.println("Write successful!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
