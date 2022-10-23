package com.game.app.entities;

import org.junit.jupiter.api.Test;

public class EnemyFactory {
    @Test
    public static Enemy getEnemy(String enemy) {
        if (enemy.equals("goblin"))
            return new Goblin();
        else return new UnknownEnemy();
    }
}
