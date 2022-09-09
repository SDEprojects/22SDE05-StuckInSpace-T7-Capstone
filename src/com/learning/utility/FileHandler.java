package com.learning.utility;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class FileHandler {

    @SuppressWarnings("unchecked")
    public JSONArray readJsonFile(String fileName) {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        JSONArray dictionary = null;

        ClassLoader classLoader = getClass().getClassLoader();
        try (InputStreamReader reader = new InputStreamReader(classLoader.getResourceAsStream(fileName))) {
            Object obj = jsonParser.parse(reader);
            dictionary = (JSONArray) obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dictionary;
    }

    public void writeJsonFile(JSONObject playerSave){

        // Add saved info to json array
        JSONArray saveList = new JSONArray();
        saveList.add(playerSave);

        // Write to JSON file
        ClassLoader classLoader = getClass().getClassLoader();
        try (FileWriter file = new FileWriter(classLoader.getResource("player_save.json").getFile())) {
            file.write(saveList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
