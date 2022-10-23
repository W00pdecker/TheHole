package com.game.app.entities;

public abstract class Enemy {


    protected int hp;
    protected int strength;

    public int getHP() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }

    public int hit(){
        return strength;
    };
}
