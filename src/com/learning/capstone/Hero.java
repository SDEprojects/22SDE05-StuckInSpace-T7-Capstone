package com.learning.capstone;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Hero {

        private final JSONArray heroDict;

    public Hero() {
            this.heroDict = readHeroFile();
        }

        @SuppressWarnings("unchecked")
        private JSONArray readHeroFile () {
            JSONParser jsonParser = new JSONParser();
            JSONArray array = new JSONArray();
            try (FileReader reader = new FileReader("hero_dictionary.json")) {
                JSONArray heroDict = (JSONArray) jsonParser.parse(reader);
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
            return heroDict;
        }

    private static void parseHeroObject(JSONObject hero) {
        JSONObject heroObject = (JSONObject) hero.get("name");

        String description = (String) heroObject.get("description");
        System.out.println(description);
    }
}
