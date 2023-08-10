package com.codecool.dungeoncrawl.data.actors.enemies;

public interface EnemyManager {
    void removeEnemy(String name);
    void removeEnemy(Enemy Enemy);
    Enemy getEnemy(String name);
    void addEnemy(Enemy Enemy);
    void moveEnemies();
}
