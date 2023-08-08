package com.codecool.dungeoncrawl.data.items;

import java.util.Set;

public class InventoryImpl implements Inventory {

    private final Set<Key> items;

    public InventoryImpl(Set<Key> items) {
        this.items = items;
    }
    @Override
    public Set<Key> getItems(){
        return this.items;
    }
    @Override
    public void add(Key item){
        items.add(item);
    }


    @Override
    public boolean contains(String key) {
        return items.stream().anyMatch(item->item.getName().equals(key));
    }
}
