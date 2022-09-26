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

public class Tower3 implements ITower {
    private int buyPrice = 150;
    private final int upgradePrice = 50;
    private final Image image = new Image("https://thumbs.dreamstime.com/b/santa-traffic-cone-against-"
            + "mascot-argaet-vector-illustration-131559662.jpg");
    private int atkDamage;
    private double atkSpeed;
    private int atkRange;
    private int x;
    private int y;
    private String name = "Rich Tower";

    public Tower3(Player p) {
        this.atkDamage = 20;
        this.atkSpeed = 0.5;
        this.atkRange = 1;
        if (p.getDifficulty().equals("Medium")) {
            buyPrice += 10;
        }
        if (p.getDifficulty().equals("Hard")) {
            buyPrice += 20;
        }
    }

    public Tower3(Player p, int x, int y) {
        this.atkDamage = 20;
        this.atkSpeed = 0.5;
        this.atkRange = 1;
        this.x = x;
        this.y = y;
        if (p.getDifficulty().equals("Medium")) {
            buyPrice += 10;
        }
        if (p.getDifficulty().equals("Hard")) {
            buyPrice += 20;
        }
    }

    @Override
    public Pane drawTower(Pane root) {
        ImageView im = new ImageView(image);
        im.setX(450);
        im.setY(100);
        im.setFitWidth(100);
        im.setFitHeight(100);
        Text price = new Text();
        price.textProperty().bind(new SimpleStringProperty(("Price: ")).concat(
                new SimpleIntegerProperty(buyPrice).asString()));
        price.setX(470);
        price.setY(250);
        price.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        price.setFill(Color.BROWN);

        Text name = new Text(this.name);
        name.setX(455);
        name.setY(90);
        name.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        name.setFill(Color.BROWN);

        root.getChildren().addAll(im, price, name);

        return root;
    }

    @Override
    public Pane showTower(Pane root) {
        ImageView im = new ImageView(image);
        im.setX(x * 48);
        im.setY(y * 48);
        im.setFitWidth(48);
        im.setFitHeight(48);

        root.getChildren().addAll(im);
        return root;
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public ImageView draw() {
        return null;
    }

    @Override
    public void upgradeTower(Player p) {
        if (p.getGold() < buyPrice) {
            atkDamage += 10;
        } else {
            atkDamage += 10;
            atkSpeed += 0.1;
            atkRange += 1;
        }
    }

    @Override
    public int getBuyPrice() {
        return buyPrice;
    }

    @Override
    public int getUpgradePrice() {
        return upgradePrice;
    }

    @Override
    public int getAtkDamage() {
        return atkDamage;
    }

    @Override
    public double getAtkSpeed() {
        return atkSpeed;
    }

    @Override
    public int getAtkRange() {
        return atkRange;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }
}
