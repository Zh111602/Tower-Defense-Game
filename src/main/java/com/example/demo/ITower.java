package com.example.demo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public interface ITower {
    Pane drawTower(Pane root);
    Pane showTower(Pane root);
    Image getImage();
    ImageView draw();
    void upgradeTower(Player p);
    int getBuyPrice();
    int getUpgradePrice();
    int getAtkDamage();
    double getAtkSpeed();
    int getAtkRange();
    int getX();
    int getY();
    void setX(int x);
    void setY(int y);
}
