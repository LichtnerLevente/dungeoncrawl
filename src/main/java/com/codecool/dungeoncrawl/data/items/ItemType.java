package com.codecool.dungeoncrawl.data.items;

public enum ItemType {
    KEY("key"),
    TOOL("tool");

    private final String name;

    ItemType(String type) {
        this.name = type;
    }

    public String getTileName() {
        return name;
    }
}
