package com.codecool.dungeoncrawl.data.actors.enemies;

import java.util.Set;

public class EnemyManagerImpl implements EnemyManager {
    private final Set<Enemy> enemies;

    public EnemyManagerImpl(Set<Enemy> enemies) {
        this.enemies = enemies;
    }
    @Override
    public void addEnemy(Enemy enemy){
        enemies.add(enemy);
    }
    @Override
    public Enemy getEnemy(String name){
      for(Enemy enemy : enemies){
          if(enemy.getName().equals(name)) return enemy;
      }
      return null;
    }
    @Override
    public void removeEnemy(String name){
        enemies.removeIf(npc -> npc.getName().equals(name));
    }

    @Override
    public void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
    }

    @Override
    public void moveEnemies() {
        for(Enemy enemy : enemies){
            if(enemy != null) enemy.move();
        }
    }
    @Override
    public Set<Enemy> getEnemies() {
        return enemies;
    }

    @Override
    public void clearEnemies() {
        enemies.clear();
    }
}
