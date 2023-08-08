package com.codecool.dungeoncrawl.data.items;


import java.util.List;

public class InventoryImpl implements Inventory {

    private final List<Item> items;

    public InventoryImpl(List<Item> items) {
        this.items = items;
    }
    @Override
    public List<Item> getItems(){
        return this.items;
    }
    @Override
    public void addItem(Item item){
        items.add(item);
    }


    @Override
    public boolean containsItem(String name) {
       return items.stream().anyMatch(item -> item.getName() == name);
    }
}
