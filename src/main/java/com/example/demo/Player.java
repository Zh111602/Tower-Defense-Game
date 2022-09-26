package com.example.demo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Player {
    private String name;
    private int monumentHP;
    private String difficulty;
    private int gold;
    private int tower1 = 0;
    private int tower2 = 0;
    private int tower3 = 0;

    public Player() { }

    public Player(String name, String difficulty) {
        this.name = name;
        this.difficulty = difficulty;
        if (difficulty.equals("Easy")) {
            gold = 300;
            monumentHP = 300;
        }
        if (difficulty.equals("Medium")) {
            gold = 200;
            monumentHP = 200;
        }
        if (difficulty.equals("Hard")) {
            gold = 100;
            monumentHP = 100;
        }

    }
    public void setMonumentHP(int num) {
        this.monumentHP = num;
    }

    public int getMonumentHP() {
        return this.monumentHP;
    }
    public String getDifficulty() {
        return difficulty;
    }
    public String getName() {
        return name;
    }
    public void setName(String n) {
        name = n;
    }
    public int getGold() {
        return gold;
    }
    public void setGold(int a) {
        gold = a;
    }
    public int getTower1() {
        return tower1;
    }
    public void setTower1(int t) {
        this.tower1 = t;
    }
    public int getTower2() {
        return tower2;
    }
    public void setTower2(int t) {
        this.tower2 = t;
    }
    public int getTower3() {
        return tower3;
    }
    public void setTower3(int t) {
        this.tower3 = t;
    }

    public void addGold(int a) {
        gold += a;
    }
    public void subGold(int a) {
        gold -= a;
    }
    public void setDifficulty(String a) {
        this.difficulty = a;
    }


    public Pane drawPlayerInfo(Pane root) {
        Text nameT = new Text();
        nameT.textProperty().bind(new SimpleStringProperty(("Name: ")).concat(
                new SimpleStringProperty(name)));
        nameT.setX(200);
        nameT.setY(1000);
        nameT.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        nameT.setFill(Color.BLACK);

        Text money = new Text();
        money.textProperty().bind(new SimpleStringProperty(("Gold: ")).concat(
            new SimpleIntegerProperty(gold).asString()));
        money.setX(600);
        money.setY(1000);
        money.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        money.setFill(Color.GREEN);

        Text diff = new Text();
        diff.textProperty().bind(new SimpleStringProperty(("Difficulty: ")).concat(
            new SimpleStringProperty(difficulty)));
        diff.setX(400);
        diff.setY(1000);
        diff.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        diff.setFill(Color.RED);

        root.getChildren().addAll(money, diff, nameT);

        return root;
    }

    public int checkTower() {
        if (tower1 == 1) {
            return 1;
        }
        if (tower2 == 1) {
            return 2;
        }
        if (tower3 == 1) {
            return 3;
        }
        return 0;
    }

}
