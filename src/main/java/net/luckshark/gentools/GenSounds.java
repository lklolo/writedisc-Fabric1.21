package net.luckshark.gentools;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class GenSounds {
    public  static void gen(String filename, String filePath){

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            File jsonFile = new File(filePath);
            JsonNode rootNode;

            if (jsonFile.exists() && jsonFile.length() != 0) {
                rootNode = objectMapper.readTree(jsonFile);
                if (!rootNode.isObject()) {
                    System.out.println("Invalid JSON structure.");
                    return;
                }
            } else {
                rootNode = objectMapper.createObjectNode();
            }

            String root = "adisc_music_disc." + filename;
            String sounds = "adisc:" + filename;

            ObjectNode newNode = objectMapper.createObjectNode();
            ArrayNode soundsArray = objectMapper.createArrayNode();
            soundsArray.add(sounds);
            newNode.set("sounds", soundsArray);

            ((ObjectNode) rootNode).set(root, newNode);

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, rootNode);

            System.out.println("Write successful");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
