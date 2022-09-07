package com.learning.datamodel;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Hero {
    //TODO heroesCurrentItems - to add items to heroes item list
    private final JSONArray heroDict;

    public Hero() {
        this.heroDict = readHeroFile();
    }

    @SuppressWarnings("unchecked")
    private JSONArray readHeroFile() {
        JSONParser jsonParser = new JSONParser();
        JSONArray heroDictionary = null;
        ClassLoader classLoader = getClass().getClassLoader();
        try (FileReader reader = new FileReader(classLoader.getResource("hero_dictionary.json").getFile())) {
            Object obj = jsonParser.parse(reader);
            heroDictionary = (JSONArray) obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return heroDictionary;
    }

}
