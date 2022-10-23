package com.game.app.entities;


public class EnemyFactory {

    public static Enemy getEnemy(String enemy) {
        if (enemy.equals("goblin"))
            return new Goblin();
        else return new UnknownEnemy();
    }
}
