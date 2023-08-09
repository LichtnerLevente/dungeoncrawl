package com.codecool.dungeoncrawl.data.actors.npcs;

import java.util.Set;

public class NPCManagerImpl implements NPCManager {
    private final Set<NPC> npcs;

    public NPCManagerImpl(Set<NPC> npcs) {
        this.npcs = npcs;
    }
    @Override
    public void addNPC(NPC npc){
        npcs.add(npc);
    }
    @Override
    public NPC getNPC(String name){
      for(NPC npc : npcs){
          if(npc.getName().equals(name)) return npc;
      }
      return null;
    }
    @Override
    public void removeNPC(String name){
        npcs.removeIf(npc -> npc.getName().equals(name));
    }

    @Override
    public void removeNPC(NPC npc) {
        npcs.remove(npc);
    }

    @Override
    public void moveNPCs() {
        for(NPC npc : npcs){
            if(npc != null) npc.move();
        }
    }
}
