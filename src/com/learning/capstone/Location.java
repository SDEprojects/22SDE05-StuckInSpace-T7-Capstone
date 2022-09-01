package com.learning.capstone;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

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
            //locDict.forEach((loc) -> parseLocationObject((JSONObject) loc, "chapter 1"));
            //System.out.println(locDict);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return locDict;
    }

    public void parseLocationObject(JSONObject location, String chapter, String start)
    {
        //Get location object within list
        JSONObject locationObject = (JSONObject) location.get(chapter);
        System.out.println(locationObject);

        String description = (String) locationObject.get(start);
        //System.out.println(description);

    }

    public JSONArray getLocDict() {
        return locDict;
    }
}
