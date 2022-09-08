package com.learning.datamodel;
import com.learning.utility.FileHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public class NPC {

    private final JSONArray npcDict;
    private String name;
    private String description;
    private String location;
    private List<String> items;

    public NPC(){
        this.npcDict = new FileHandler().readJsonFile("npc_dictionary.json");
        buildnpc("default");
    }

    public void buildnpc(String name){
        for (Object obj : this.npcDict){
            JSONObject npc = (JSONObject) obj;
            JSONObject attributes = (JSONObject) npc.get(name);
            setName((String) attributes.get("name"));
            setDescription((String) attributes.get("description"));
            setLocation((String) attributes.get("location"));
            JSONArray npcitems = (JSONArray) attributes.get("equipped items");
            for (Object item : npcitems) {
                this.items.add((String) item);
            }

        }
    }

    private static void parseNpcObject(JSONObject npc) {

        JSONObject npcObject = (JSONObject) npc.get("npc");

        String description = (String) npcObject.get("description");
        System.out.println(description);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}
