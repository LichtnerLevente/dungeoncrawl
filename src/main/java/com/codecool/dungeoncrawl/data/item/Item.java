package com.codecool.dungeoncrawl.data.item;

public class Item {
    private String name;
    private  int id;
    public Item(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
