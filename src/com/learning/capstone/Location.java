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
        JSONArray locationDict = null;
        try (FileReader reader = new FileReader("location_dictionary.json")) {
            Object obj = jsonParser.parse(reader);
            locationDict = (JSONArray) obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return locationDict;
    }

    public JSONArray getLocDict() {
        return locDict;
    }

}

