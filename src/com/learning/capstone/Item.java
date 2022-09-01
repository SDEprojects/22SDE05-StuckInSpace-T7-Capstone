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
    // Define variables to be used to invoke JSON file.
    private final JSONArray itemDict;
    private String item;
    private String name;
    private String description;
    private String location;
    private String store;
    private int power;
    private int defense;

    // Multiple layers JSON call starts here.
    public Item() {
        this.itemDict = readItemFile();
    }

    private JSONArray readItemFile() {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("./item_dictionary.json")) {
            //Read JSON file
            Object item_obj = jsonParser.parse(reader);

            JSONArray itemList = (JSONArray) item_obj;
            System.out.println(itemList); // **** for dev process only, need to Delete.

            //Iterator over item array
            itemList.forEach(item -> parseItemObject((JSONObject) item));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return itemDict;
    }

    private static void parseItemObject(JSONObject item) {
        //Get single object within list
        JSONObject itemObject = (JSONObject) item.get("fuel");

        //Get item name
        String itemName = (String) itemObject.get("name");
        System.out.println("The item is: " + itemName + ".");

        //Get item description
        String itemDescription = (String) itemObject.get("description");
        System.out.println("Description: " + itemDescription + ".");

        //Get item location
        String itemLocation = (String) itemObject.get("location");
        System.out.println("It is at " + itemLocation + ".");

        //Get item store
        String itemStore = (String) itemObject.get("store");
        System.out.println("It is in " + itemStore + ".");

        //Get item power
        String itemPower = (String) itemObject.get("power");
        System.out.println("It has " + itemPower + " power.");

        //Get item defense
        String itemDefense = (String) itemObject.get("defense");
        System.out.println("It has " + itemDefense + " defense.");

    }

    public JSONArray getItemDict() {
        return itemDict;
    }

    // Multiple layers JSON call ends here.


//    // Single layer JSON call function starts here.
//    public static void main(String[] args) {
//        JSONParser parser = new JSONParser();
//        try {
//            Object item = parser.parse(new FileReader("./item_dictionary.json"));
//            JSONObject jsonObject = (JSONObject)item;
//            String Test = (String)jsonObject.get("fuel_name");
//            System.out.println("You found some: " + Test);
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
//    // Single layer JSON call function ends here.

}
