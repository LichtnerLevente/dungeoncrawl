package com.codecool.dungeoncrawl.data.actors.enemies;

import java.util.Optional;
import java.util.Set;

import static java.util.Arrays.stream;

public class EnemyManagerImpl implements EnemyManager{
    private Set<Enemy> enemies;

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
        enemies.removeIf(enemy -> enemy.getName().equals(name));
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
}
