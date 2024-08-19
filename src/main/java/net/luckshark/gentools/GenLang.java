package net.luckshark.gentools;

import net.luckshark.tool.CapitalizeFirstLetter;

import java.io.FileWriter;
import java.io.IOException;

public class GenLang {
    public  static void gen(String filename, String upperCaseName, String filePath){

        String name = "结束バンド";
        String capitalizeFirstLetterFileName = CapitalizeFirstLetter.capitalizeFirstLetter(filename);

        String contentToAppend1 = "translationBuilder.add(ModItems.ADISC_MUSIC_DISC_" + upperCaseName + ", \"" + name + "\");\n";
        String contentToAppend2 = "translationBuilder.add(\"jukebox_song.adisc.adisc_" + filename + "\", \"" + name + " - " + capitalizeFirstLetterFileName + "\");\n";

        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            fileWriter.write(contentToAppend1);
            fileWriter.write(contentToAppend2);
            System.out.println("Write successful!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
