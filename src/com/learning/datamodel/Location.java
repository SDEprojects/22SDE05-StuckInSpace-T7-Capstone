package com.learning.datamodel;

import com.learning.utility.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Location {
    private final JSONArray locDict;
    private String missionName;
    private String startPosition;

    public Location(){
        this.locDict = new FileReader().readJsonFile("location_dictionary.json");
        buildMap("mission_01");
    }

    public void buildMap(String missionName){
        for (Object obj : this.locDict){
            JSONObject mission = (JSONObject) obj;
            JSONObject attributes = (JSONObject) mission.get(missionName);

            setMissionName((String) attributes.get("name"));
            setStartPosition((String) attributes.get("start_position"));

        }
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public String getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(String startPosition) {
        this.startPosition = startPosition;
    }

    public JSONArray getLocDict() {
        return locDict;
    }
}

