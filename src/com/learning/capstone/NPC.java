package com.learning.capstone;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
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
        JSONArray array = new JSONArray();
        try (FileReader reader = new FileReader("npc_dictionary.json")) {
            JSONArray npcDict = (JSONArray) jsonParser.parse(reader);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return npcDict;
    }

    private static void parseNpcObject(JSONObject npc) {
        JSONObject npcObject = (JSONObject) npc.get("name");

        String description = (String) npcObject.get("description");
        System.out.println(description);
    }
}
