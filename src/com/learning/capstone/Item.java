package com.learning.capstone;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Item {
    // Define variable to parse JSON file.
    private final JSONArray itemDict;
    // This is the variable when game called out an item.
    private String itemCalledOut = "toolkit";

    // Define variables from JSON file, so they could be used to create getters.
    private String itemName;
    private String itemDescription;
    private String itemLocation;
    private String itemStore;
    private String itemPower;
    private String itemDefense;

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
//            System.out.println(itemList); // **** for dev process only, need to Delete.

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
    private void parseItemObject(JSONObject item) {

        //Get single object within list
        JSONObject itemObject = (JSONObject) item.get(itemCalledOut);

        //Get item name, description, location, store, power, defense.
        itemName = (String) itemObject.get("name");
        itemDescription = (String) itemObject.get("description");
        itemLocation = (String) itemObject.get("location");
        itemStore = (String) itemObject.get("store");
        itemPower = (String) itemObject.get("power");
        itemDefense = (String) itemObject.get("defense");

    }

    public JSONArray getItemDict() {
        return itemDict;
    }
    // Multiple layers JSON call ends here.

    // Display item details.
    public void showItemCard(){
        System.out.println(
         "\n" + itemName +
         "\n" + itemDescription +
         "\nIt has " + itemPower
         + " \uD83E\uDD4APower  and " + itemDefense
         + " \uD83D\uDEE1Defense ."
        );
    }

    // Getters for each attribute of the item.

    public String getItemName() {
        return itemName;
    }
    public String getItemDescription() {
        return itemDescription;
    }
    public String getItemLocation() {
        return itemLocation;
    }
    public String getItemStore() {
        return itemStore;
    }
    public String getItemPower() {
        return itemPower;
    }
    public String getItemDefense() {
        return itemDefense;
    }

    public void addToBackpack(){
        //TODO This is the function to create a list to keep items with player,
        // if the getItemStore == "inventory" add to this list
        // after list is created, generate a getter so the player could check their backpack.
    }

    public void addToCarry(){
        // TODO This is the function to create a list to store what items are in hand,
        // if the getItemStore == "carry" add to this list.
        // after list is created, generate a getter.
    }

    public void addToWear(){
        // TODO This is the function to create a list to store the items wearing by the player.
        // if the getItemStore == "wear" add to this list.
        // after list is created, generate a getter.
    }


}
