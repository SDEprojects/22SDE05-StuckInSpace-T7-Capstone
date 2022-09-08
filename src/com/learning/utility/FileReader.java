package com.learning.utility;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {

    @SuppressWarnings("unchecked")
    public JSONArray readJsonFile(String fileName) {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        JSONArray dictionary = null;
        ClassLoader classLoader = getClass().getClassLoader();
        try (java.io.FileReader reader = new java.io.FileReader(classLoader.getResource(fileName).getFile())) {
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
}
