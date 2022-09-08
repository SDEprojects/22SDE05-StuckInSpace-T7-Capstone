package com.learning.datamodel;

import com.learning.utility.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    //TODO heroesCurrentItems - to add items to heroes item list
    private final JSONArray heroDict;
    private String heroName;
    private String description;
    private String skills;
    private List<String> items;
    private long healthMax;
    private long healthMin;
    private long initialHealth;

    private JSONObject currentPosition;

    public Hero(){
        this.heroDict = new FileReader().readJsonFile("hero_dictionary.json");
        buildHero("default");
    }

    public void buildHero(String heroName){
        this.items = new ArrayList<>();
        for (Object obj : this.heroDict){
            JSONObject hero = (JSONObject) obj;
            JSONObject attributes = (JSONObject) hero.get("hero");
            if(heroName.isEmpty()){
                setHeroName((String) attributes.get("name"));
            } else {
                setHeroName((String) attributes.get(heroName));
            }
            setDescription((String) attributes.get("description"));
            setSkills((String) attributes.get("skills"));
            setHealthMin((Long) attributes.get("healthMin"));
            setHealthMax((Long) attributes.get("healthMax"));
            setInitialHealth((Long) attributes.get("initialHealth"));
            JSONArray equippedItems = (JSONArray) attributes.get("equipped items");
            for (Object item : equippedItems) {
                this.items.add((String) item);
            }
        }
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }

    public long getHealthMax() {
        return healthMax;
    }

    public void setHealthMax(long healthMax) {
        this.healthMax = healthMax;
    }

    public long getHealthMin() {
        return healthMin;
    }

    public void setHealthMin(long healthMin) {
        this.healthMin = healthMin;
    }

    public long getInitialHealth() {
        return initialHealth;
    }

    public void setInitialHealth(long initialHealth) {
        this.initialHealth = initialHealth;
    }

    public void displayHeroProfile(){
        /**
         * TODO: takes in current location, exits to current location, and items in the current location
         *
         */
        System.out.println("==============================================================");
        System.out.println("| Name:  " + getHeroName().toUpperCase());
        System.out.println("==============================================================");
        System.out.println();
        System.out.println("**************************************************************");
        System.out.println("**************************************************************");
        System.out.println();
        System.out.println("==============================================================");
        System.out.println("| Background:  " + getDescription());
        System.out.println("| Skills:      " + getSkills());
        System.out.println("| Items:       " + getItems());
        System.out.println("==============================================================");
    }
}
