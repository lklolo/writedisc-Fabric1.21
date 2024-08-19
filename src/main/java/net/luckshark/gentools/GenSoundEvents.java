package net.luckshark.gentools;

import java.io.FileWriter;
import java.io.IOException;

public class GenSoundEvents {
    public  static void gen(String filename, String upperCaseName, String filePath){

        String contentToAppend = "public static final RegistryEntry.Reference<SoundEvent> ADISC_MUSIC_DISC_" + upperCaseName + " = registerReference(\"adisc_music_disc." + filename + "\");\n";

        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            fileWriter.write(contentToAppend);
            System.out.println("Write successful!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
