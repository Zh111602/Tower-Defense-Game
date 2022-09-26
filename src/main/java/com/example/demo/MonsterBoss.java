package com.example.demo;

import javafx.scene.layout.Pane;

public class MonsterBoss implements IMonster {
    private int health;
    private int movementSpeed;
    private double atkSpeed;
    private int atkDamage;
    private int atkRange;
    private int reward;
    private int x;
    private int y;

    @Override
    public Pane drawEnemy(Pane p) {
        return null;
    }

    @Override
    public boolean isDead() {
        return health <= 0 ? true : false;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int newHealth) {
        health = newHealth;
    }

    @Override
    public int getAtkDamage() {
        return atkDamage;
    }

    @Override
    public int getAtkRange() {
        return atkRange;
    }

    @Override
    public double getAtkSpeed() {
        return atkSpeed;
    }

    @Override
    public int getMoveSpeed() {
        return movementSpeed;
    }

    @Override
    public int getReward() {
        return reward;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
