package com.codecool.dungeoncrawl.data.actors.enemies;

public interface EnemyManager {
    void removeEnemy(String name);
    Enemy getEnemy(String name);
    void addEnemy(Enemy enemy);
}
