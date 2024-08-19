package net.luckshark.gentools;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class GenJukebox_song {
    public  static void gen(String filename, double duration, String directoryPath){

        String translate = "jukebox_song.adisc.adisc_" + filename;
        String sound_event = "adisc:adisc_music_disc." + filename;

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode jsonObject = objectMapper.createObjectNode();

        jsonObject.put("comparator_output", 15);
        ObjectNode descriptionNode = jsonObject.putObject("description");
        descriptionNode.put("translate", translate);
        jsonObject.put("length_in_seconds", duration);
        jsonObject.put("sound_event", sound_event);

        File jsonFile = new File(directoryPath + "/" + "adisc_" + filename + ".json");

        try {
            objectMapper.writeValue(jsonFile, jsonObject);
            System.out.println("Write successful!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
