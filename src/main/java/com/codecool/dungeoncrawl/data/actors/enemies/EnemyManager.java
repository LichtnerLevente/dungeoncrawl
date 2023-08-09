package com.codecool.dungeoncrawl.data.actors.enemies;

public interface EnemyManager {
    void removeEnemy(String name);
    void removeEnemy(Enemy enemy);
    Enemy getEnemy(String name);
    void addEnemy(Enemy enemy);
    void moveEnemies();
}
