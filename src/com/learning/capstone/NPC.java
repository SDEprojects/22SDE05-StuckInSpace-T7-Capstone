package com.learning.capstone;
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
        JSONArray array = new JSONArray();
        try (FileReader reader = new FileReader("npc_dictionary.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray npcDict = (JSONArray) obj;
            System.out.println("This is my NPC" + npcDict);
            npcDict.forEach((npc) -> parseNpcObject((JSONObject) npc));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return npcDict;
    }

    private static void parseNpcObject(JSONObject npc) {

        JSONObject npcObject = (JSONObject) npc.get("npc");

        String description = (String) npcObject.get("description");
        System.out.println(description);
    }
}
