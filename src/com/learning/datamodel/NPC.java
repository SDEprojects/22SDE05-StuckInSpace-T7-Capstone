package com.learning.datamodel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class NPC {

    private final JSONArray npcDict;

    public NPC() {
        this.npcDict = readNpcFile();
    }

    @SuppressWarnings("unchecked")
    private JSONArray readNpcFile() {
        JSONParser jsonParser = new JSONParser();
        JSONArray npcDictionary = null;
        ClassLoader classLoader = getClass().getClassLoader();
        try (FileReader reader = new FileReader(classLoader.getResource("npc_dictionary.json").getFile())) {
            Object obj = jsonParser.parse(reader);
            npcDictionary = (JSONArray) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return npcDictionary;
    }

    private static void parseNpcObject(JSONObject npc) {

        JSONObject npcObject = (JSONObject) npc.get("npc");

        String description = (String) npcObject.get("description");
        System.out.println(description);
    }
}
