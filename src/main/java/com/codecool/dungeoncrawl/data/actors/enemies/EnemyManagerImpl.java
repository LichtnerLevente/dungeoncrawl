package com.codecool.dungeoncrawl.data.actors.enemies;

import java.util.Optional;
import java.util.Set;

import static java.util.Arrays.stream;

public class EnemyManagerImpl implements EnemyManager{
    private Set<Enemy> enemies;

    public EnemyManagerImpl(Set<Enemy> enemies) {
        this.enemies = enemies;
    }
    public void addEnemy(Enemy enemy){
        enemies.add(enemy);
    }
    public Enemy getEnemy(String name){
      for(Enemy enemy : enemies){
          if(enemy.getName().equals(name)) return enemy;
      }
      return null;
    }
    void removeEnemy(String name){
        enemies.removeIf(enemy -> enemy.getName().equals(name));
    }


}
