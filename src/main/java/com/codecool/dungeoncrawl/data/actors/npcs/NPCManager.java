package com.codecool.dungeoncrawl.data.actors.npcs;

public interface NPCManager {
    void removeNPC(String name);
    void removeNPC(NPC NPC);
    NPC getNPC(String name);
    void addNPC(NPC NPC);
    void moveNPCs();
}
