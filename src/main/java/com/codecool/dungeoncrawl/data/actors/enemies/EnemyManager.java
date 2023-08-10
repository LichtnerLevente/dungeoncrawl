package com.codecool.dungeoncrawl.data.actors.enemies;

import java.util.Set;

public interface EnemyManager {
    void removeEnemy(String name);
    void removeEnemy(Enemy Enemy);
    void clearEnemies();
    Enemy getEnemy(String name);
    Set<Enemy> getEnemies();
    void addEnemy(Enemy Enemy);
    void moveEnemies();
}
