package net.luckshark.gentools;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class GenModels {
    public  static void gen(String filename, String directoryPath){

        String texturesName = "book3";

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode jsonObject = objectMapper.createObjectNode();

        jsonObject.put("parent", "minecraft:item/generated");
        ObjectNode textures = jsonObject.putObject("textures");
        textures.put("layer0", "adisc:item/adisc_music_disc_" + texturesName);

        ObjectNode display = jsonObject.putObject("display");

        ObjectNode thirdPersonRightHand = display.putObject("thirdperson_righthand");
        thirdPersonRightHand.set("rotation", createArrayNode(objectMapper, 0, 0, 0));
        thirdPersonRightHand.set("translation", createArrayNode(objectMapper, 0, 0, 0));
        thirdPersonRightHand.set("scale", createArrayNode(objectMapper, 0.75, 0.75, 0.75));

        ObjectNode thirdPersonLeftHand = display.putObject("thirdperson_lefthand");
        thirdPersonLeftHand.set("rotation", createArrayNode(objectMapper, 0, 0, 0));
        thirdPersonLeftHand.set("translation", createArrayNode(objectMapper, 0, 0, 0));
        thirdPersonLeftHand.set("scale", createArrayNode(objectMapper, 0.75, 0.75, 0.75));

        ObjectNode firstPersonRightHand = display.putObject("firstperson_righthand");
        firstPersonRightHand.set("rotation", createArrayNode(objectMapper, -12, -24, 0));
        firstPersonRightHand.set("translation", createArrayNode(objectMapper, 0, 4, -2));
        firstPersonRightHand.set("scale", createArrayNode(objectMapper, 1, 1, 1));

        ObjectNode firstPersonLeftHand = display.putObject("firstperson_lefthand");
        firstPersonLeftHand.set("rotation", createArrayNode(objectMapper, -12, -24, 0));
        firstPersonLeftHand.set("translation", createArrayNode(objectMapper, 0, 4, -2));
        firstPersonLeftHand.set("scale", createArrayNode(objectMapper, 1, 1, 1));


        File jsonFile = new File(directoryPath + "/" + "adisc_music_disc_" + filename + ".json");

        try {
            objectMapper.writeValue(jsonFile, jsonObject);
            System.out.println("Write successful!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static ArrayNode createArrayNode(ObjectMapper objectMapper, double... values) {
        ArrayNode arrayNode = objectMapper.createArrayNode();
        for (double value : values) {
            arrayNode.add(value);
        }
        return arrayNode;
    }
}
