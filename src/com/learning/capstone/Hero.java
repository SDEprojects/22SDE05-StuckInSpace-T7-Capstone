package com.learning.capstone;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Hero {

    //TODO heroesCurrentItems - to add items to heroes item list

    private final JSONArray heroDict;

    public Hero() {
            this.heroDict = readHeroFile();
        }

        @SuppressWarnings("unchecked")
        private JSONArray readHeroFile () {
            JSONParser jsonParser = new JSONParser();
            JSONArray array = new JSONArray();
            try (FileReader reader = new FileReader("hero_dictionary.json")) {
                Object obj = jsonParser.parse(reader);
                JSONArray heroDict = (JSONArray) obj;
                System.out.println("this is my hero" + heroDict);
                heroDict.forEach((hero) -> parseHeroObject((JSONObject) hero));
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
            return heroDict;
        }

        private static void parseHeroObject(JSONObject hero) {

        JSONObject heroObject = (JSONObject) hero.get("hero");

        String description = (String) heroObject.get("description");
        System.out.println(description);
    }
}
