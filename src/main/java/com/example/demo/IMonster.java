package com.example.demo;
import javafx.scene.layout.Pane;

public interface IMonster {
    Pane drawEnemy(Pane p);
    boolean isDead();
    int getHealth();
    void setHealth(int newHealth);
    int getAtkDamage();
    int getAtkRange();
    double getAtkSpeed();
    int getMoveSpeed();
    int getReward();
    int getX();
    int getY();
}
