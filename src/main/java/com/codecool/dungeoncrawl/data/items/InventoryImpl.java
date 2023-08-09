package com.codecool.dungeoncrawl.data.items;

import java.util.Set;

public class InventoryImpl implements Inventory {

    private final Set<Item> items;

    public InventoryImpl(Set<Item> items) {
        this.items = items;
    }


    @Override
    public Set<Item> getItems(){
        return this.items;
    }
    @Override
    public void add(Item item){
        items.add(item);
    }
    @Override
    public boolean contains(String name) {
        return items.stream().anyMatch(item->item.getName().equals(name));
    }
}
