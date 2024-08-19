package net.luckshark.gentools;

import java.io.FileWriter;
import java.io.IOException;

public class GenItems {
    public  static void gen(String filename, String upperCaseName , String filePath){

        String contentToAppend = "public static final Item ADISC_MUSIC_DISC_" + upperCaseName + " = registerItems(\"adisc_music_disc_" + filename + "\", new Item(new Item.Settings().maxCount(1).rarity(Rarity.RARE).jukeboxPlayable(ModJukeboxSongs.ADISC_" + upperCaseName + ")));\n";

        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            fileWriter.write(contentToAppend);
            System.out.println("Write successful!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
