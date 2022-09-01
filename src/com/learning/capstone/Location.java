package com.learning.capstone;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class Location {
    private final JSONArray locDict;

    public Location() {
        this.locDict = readLocationFile();
    }

    @SuppressWarnings("unchecked")
    private JSONArray readLocationFile() {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("location_dictionary.json")) {
            Object obj = jsonParser.parse(reader);

            JSONArray locDict = (JSONArray) obj;
            //System.out.println(locDict);

            locDict.forEach((loc) -> parseLocationObject((JSONObject) loc));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return locDict;
    }

    private static void parseLocationObject(JSONObject location)
    {
        //Get location object within list
        JSONObject locationObject = (JSONObject) location.get("structure");

        //Get description of location
        String description = (String) locationObject.get("Start_description");
        System.out.println(description);
    }

    public JSONArray getLocDict() {
        return locDict;
    }
}
