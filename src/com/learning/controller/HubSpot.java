package com.learning.controller;

import com.learning.datamodel.Hero;
import com.learning.datamodel.Item;
import com.learning.datamodel.NPC;
import com.learning.utility.FileHandler;
import com.learning.view.SaveGame;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HubSpot {
    SaveGame savegame;
    private Hero hero;
    public Item item;
    private NPC npcs;

    // TODO: Link this to backpack ds
    private List<String> playerItems;
    JSONObject heroPosition;

    public HubSpot() {
        this.savegame = new SaveGame();
        this.heroPosition = new JSONObject();
        this.item = new Item();
        this.heroPosition.put("Current_position", "hangar");
        this.heroPosition.put("Previous_position", "hub");
        this.hero = new Hero();
        this.playerItems = new ArrayList<>();
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public NPC getNpcs() {
        return npcs;
    }

    public void setNpcs(NPC npcs) {
        this.npcs = npcs;
    }

    public void loadSavedGame(String playerName, JSONArray playerItems) {
        ArrayList<String> storeItems = new ArrayList<>();

        getHero().setHeroName(playerName);
        for (Object obj : playerItems) {
            storeItems.add((String) obj);
        }
        setPlayerItems(storeItems);
    }

    public void setPlayerName(String name) {
        this.hero.setHeroName(name);
    }

    public String getPlayerName() {
        return this.hero.getHeroName();
    }

    public String showPlayerProfile() {
        return getHero().displayHeroProfile();
    }

    public void setHeroPosition(String position) {
        updatePositions((String) this.heroPosition.get("Current_position"), position);
    }

    public String getHeroPosition() {
        return (String) this.heroPosition.get("Current_position");
    }

    public String getHeroPrevPosition() {
        return (String) this.heroPosition.get("Previous_position");
    }

    private void updatePositions(String oldPosition, String newPosition) {
        this.heroPosition.put("Previous_position", oldPosition);
        this.heroPosition.put("Current_position", newPosition);
    }

    public void getHeroStatus() {

    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<String> getPlayerItems() {
        return this.item.getBackpackList();
    }

    public void setPlayerItems(ArrayList<String> playerItems) {
        this.playerItems = playerItems;
        getItem().setBackpackList(playerItems);
    }

    // TODO Henry added some functions starts here.

    // Create list of item by location,

    public void initiateItemLocationList() {
//        JSONArray itemJSON = new FileHandler().readJsonFile("item_dictionary.json");
        JSONArray itemJSON = item.getItemDict();
        for (Object obj : itemJSON) {
            JSONObject objAll = (JSONObject) obj; // Turn item JSON into obj.
            Set allName = objAll.keySet(); // Get all the first layer of names item.json.
            // turn all first layer of names into a list.
            List<String> keyList = new ArrayList<>(allName.size()); // keyList if the list of first layer names.
            for (Object keyItemName : allName) {
                keyList.add(keyItemName.toString());
            }
            // Create a list using location as the key.
            for (String keyItemName : keyList) {
                JSONObject attribute = (JSONObject) objAll.get(keyItemName); // All attributes for each item.
                String itemLoc = attribute.get("location").toString();
                item.getItemLocationList().put(itemLoc, new ArrayList<>());
            }

            // Print each item in their location.
            for (String keyItemName : keyList) {
//                System.out.println(keyItemName);
                JSONObject attribute = (JSONObject) objAll.get(keyItemName); // All attributes for each item.
                String itemLoc = attribute.get("location").toString();
                item.getItemLocationList().get(itemLoc).add(keyItemName);
            }
//            System.out.println(item.getItemLocationList()); // Delete me, for test.
        } // This } closes (Object obj : itemJSON) for loop line 146.
    } // This } closes the findNameOfLocation function.

    // This will print a list of items based on hero current location.
    public ArrayList<String> lookAction(String currentPosition) {
//        System.out.println(item.getItemLocationList()); // delete me.
        item.setItemFound(item.getItemLocationList().get(currentPosition));
        // Set a temporary variable to save the item found in place.
        ArrayList<String> itemsHere = item.getItemFound();

        // If there are items available in the area, show them to player.
//        if (itemsHere == null) {
//            System.out.println("\uD83D\uDE12 No item is found at this location");
//        } else {
//            if (item.getBackpackList().contains(itemsHere.get(0)) == false) { // if the player doesn't have the item.
//                for (int i = 0; i < itemsHere.size(); i++) {
//                    item.setItemCalledOut(itemsHere.get(i));
//                    item.parseItemObject();
//                    String itemFoundName = item.getItemName();
//                    System.out.println("\uD83D\uDE00 You found " + itemFoundName);
//                }
//            } else {
//                System.out.println("\uD83D\uDE12 No item is found at this location");
//            }
//        }
        return itemsHere;
    }

    // Check if there are items left at this location.
    public boolean itemFoundHere() {
        boolean isFound = true;
        if (item.getItemFound() == null) {
            isFound = false;
        }
        return isFound;
    }

    // Pick function.
    public void addToInventory() {
        // TODO add the item to backpack, remove them from itemFoundMap.
        item.setItemFound(item.getItemLocationList().get(getHeroPosition()));
        // Set a temporary variable to save the item found in place.
        ArrayList<String> itemsHere = item.getItemFound();
        if (itemsHere == null) {
            System.out.println("\uD83D\uDE12 No item is found at this location");
        } else {
            for (int i = 0; i < itemsHere.size(); i++) {
                item.getBackpackList().add(itemsHere.get(i));
                item.setItemCalledOut(itemsHere.get(i));
                item.parseItemObject();
                System.out.println(item.getItemName() + " is added to your backpack \uD83C\uDF92");
            }
            item.getItemLocationList().remove(getHeroPosition());
        }
    }

    public ArrayList<String> addItemToInventory(String text) {
        ArrayList<String> inventory = new ArrayList<>();
        inventory.add(text);
        return inventory;
    }

    // Initiate the backpack based the Hero's attribute. Will run this once when game starts.
    public void initiateInventory() {
        for (int i = 0; i < hero.getItems().size(); i++) {
            item.getBackpackList().add(hero.getItems().get(i));
        }
        item.setBackpackList(item.getBackpackList());
    }
    //god mode
    public  ArrayList<String> godMode() {
        JSONArray itemJSON = item.getItemDict();
        ArrayList<String> keyList = null;
        for (Object obj : itemJSON) {
            JSONObject objAll = (JSONObject) obj;
            Set allName = objAll.keySet();
            keyList = new ArrayList<>(allName.size());
            for (Object keyItemName : allName) {
                keyList.add(keyItemName.toString());
            }
        }
        return keyList;
    }


    //Audio
 /*   public static void startMusic(File file) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        //Scanner scanner = new Scanner(System.in);
        //File file = new File("resources/DivKid.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();

    }*/









    //Audio
 /*   public static void startMusic(File file) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        //Scanner scanner = new Scanner(System.in);
        //File file = new File("resources/DivKid.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();

    }*/
    public static void manageMusic(File file, String input) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        //Scanner scanner = new Scanner(System.in);
        //File file = new File("resources/DivKid.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        switch (input){
            case ("start music"):
                clip.start();
                break;
            case ("stop music"):
                clip.stop();
                //break;
        }


    }

//    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
//        File file = new File("resources/DivKid.wav");
//        manageMusic(file, "start music");
//    }


    public static void stopMusic(File file) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.stop();

    }


    // Show inventory function.
    public ArrayList<String> showInventory() {
//        System.out.println(item.getBackpackList()); // Delete me, for test.
        ArrayList<String> inv = item.getBackpackList();
        for (int i = 0; i < inv.size(); i++) {
//            System.out.println(inv.get(i)); // Delete me, for test.
            JSONArray itemJSON = item.getItemDict();
            for (Object obj : itemJSON) {
                JSONObject objAll = (JSONObject) obj; // Turn item JSON into obj.
                JSONObject attribute = (JSONObject) objAll.get(inv.get(i));
                System.out.println((i + 1) + ". " + attribute.get("name"));
            }
        }
        return inv;
    }

    // Generate item card function.
    public void showItemCard(String itemNum) {
        Integer itemNumInput = Integer.parseInt(itemNum);
        String it = item.getBackpackList().get(itemNumInput - 1);
        item.setItemCalledOut(it);
        item.parseItemObject();
        if (item.getItemName() != null) {
            System.out.println(
                    "\n" + item.getItemName() +
                            "\n" + item.getItemDescription() +
                            "\nIt has " + item.getItemPower()
                            + " \uD83E\uDD4APower  and " + item.getItemDefense()
                            + " \uD83D\uDEE1Defense ."
            );
        } else {
            System.out.println("You don't have this item.");
        }

    }

    // TODO save game file writer is not working.
    public void autoSaveGame() {
        JSONObject saveGameData = new JSONObject();
        JSONArray backpack = new JSONArray();
        for (String item : this.item.getBackpackList()) {
            backpack.add(item);
        }
        saveGameData.put("playerName", this.hero.getHeroName());
        saveGameData.put("playerInventory", backpack);
        System.out.println("Your game has been Saved!");
        new FileHandler().writeJsonFile(saveGameData);
    }

    public static boolean checkInventoryInputType(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    public SaveGame getSavegame() {
        return savegame;
    }

    public void setSavegame(SaveGame savegame) {
        this.savegame = savegame;
    }

}
