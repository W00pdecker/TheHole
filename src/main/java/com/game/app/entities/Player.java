package com.game.app.entities;


import java.util.ArrayList;
import java.util.List;

public class Player {
    private static Player instance;
    private static String name;
    private static String weapon;
    private static String ring;
    private static List<String> loot = new ArrayList<>();
    private static int level = 0;


    private static int hp = 100;

    private Player(String name) {
        Player.name = name;
    }

    public static synchronized Player getInstance(String name) {
        if (instance == null) {
            instance = new Player(name);
        }
        return instance;
    }

    public static Player getInstance() {
        return instance;
    }

    public static int hit() {
        int result = switch (weapon) {
            case "Sword" -> 6;
            case "Axe" -> 8;
            case "Handgun" -> 25;
            default -> throw new IllegalStateException("Unexpected value: " + weapon);
        };
        return result;
    }

    public static String getName() {
        return name;
    }

    public static String getWeapon() {
        return weapon;
    }

    public static String getRing() {
        return ring;
    }

    public static int getLevel() {
        return level;
    }

    public static void setName(String name) {
        Player.name = name;
    }

    public static void setWeapon(String weapon) {
        Player.weapon = weapon;
    }

    public static void setRing(String ring) {
        Player.ring = ring;
    }

    public static void setLevel(int level) {
        Player.level = level;
    }

    public static int getHp() {
        return hp;
    }
    public static void setHp(int hp) {
        Player.hp = hp;
    }

    public static void addLoot(String loot) {
        Player.loot.add(loot);
    }

    public static List<String> getLoot() {
        return loot;
    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
