package com.learning.capstone;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Item {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {
            Object item = parser.parse(new FileReader("./item_dictionary.json"));
            JSONObject jsonObject = (JSONObject)item;
            String Test = (String)jsonObject.get("Test");
            System.out.println("Test: " + Test);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}
