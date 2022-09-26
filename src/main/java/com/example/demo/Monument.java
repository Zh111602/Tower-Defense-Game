package com.example.demo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Monument {
    private int health;
    private int x;
    private int y;
    private boolean destroyed;
    private boolean attacked;
    private final Image monumentImg = new Image("https://i.ibb.co/XbPqNpf/monument-Tile.png");

    public Monument() {
        // Depends on difficulty
        health = 300;
        x = 1;
        y = 1;
        destroyed = false;
    }

    public Monument(String difficulty) {
        if (difficulty.equals("Easy")) {
            health = 300;
        }
        if (difficulty.equals("Medium")) {
            health = 200;
        }
        if (difficulty.equals("Hard")) {
            health = 100;
        }
        // set coordinates for monument
        x = 1;
        y = 1;
        destroyed = false;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setHealth(int h) {
        health = h;
    }

    public Pane drawMonument(Pane root) {
        ImageView iV = new ImageView(monumentImg);
        iV.setX(17 * 48);
        iV.setY(17 * 48);

        Text mHp = new Text();
        mHp.textProperty().bind(new SimpleStringProperty(("HP: ")).concat(
                new SimpleIntegerProperty(health).asString()));
        mHp.setX(800);
        mHp.setY(1000);
        mHp.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        mHp.setFill(Color.BROWN);

        // implement being attacked animation
        /*
        ImageView iV2 = new ImageView();
        if (attacked) {
            iV2.setImage(new Image("file:resources/deduct.png"));
            iV2.setX((x + 1.8) * 32);
            iV2.setY((y + 1.2) * 32);
            iV2.setFitHeight(15);
            iV2.setFitWidth(15);
            attacked = false;
        }
        */

        root.getChildren().addAll(iV, mHp);
        return root;
    }

    public int getHealth() {
        return this.health;
    }

}
