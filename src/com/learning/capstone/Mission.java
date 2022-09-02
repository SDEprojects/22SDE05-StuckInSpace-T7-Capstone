package com.learning.capstone;

public class Mission {
    private Location locations;
    private Item items = new Item();;
    private NPC npcs = new NPC();
    private Hero hero = new Hero();

    public Mission(){
        this.locations = new Location();
        this.items = new Item();
        this.npcs = new NPC();
        this.hero = new Hero();
    }

    public Location getLocations() {
        return locations;
    }

    public void setLocations(Location locations) {
        this.locations = locations;
    }

    public Item getItems() {
        return items;
    }

    public void setItems(Item items) {
        this.items = items;
    }

    public NPC getNpcs() {
        return npcs;
    }

    public void setNpcs(NPC npcs) {
        this.npcs = npcs;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
