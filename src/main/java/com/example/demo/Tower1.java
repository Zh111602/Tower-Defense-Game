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

public class Tower1 implements ITower {
    private int buyPrice = 50;
    private final int upgradePrice = 50;
    private final Image image = new Image("https://th.bing.com/th/id/R.fa8738188e95494dd042ba90968612c1"
            + "?rik=O1pAAhzLOJa5vQ&riu=http%3a%2f%2fclipground.com%2fimages%"
            + "2ftower-clipart-3.jpg&ehk=QucJz1IpqJpExu2D9CpzaC6B2pTOkPOtV2uEzt30s"
            + "Xw%3d&risl=&pid=ImgRaw&r=0");
    private int atkDamage;
    private double atkSpeed;
    private int atkRange;
    private int x;
    private int y;
    private final String name = "Weak Tower";

    public Tower1(Player p) {
        this.atkDamage = 10;
        this.atkSpeed = 0.7;
        this.atkRange = 2;
        if (p.getDifficulty().equals("Medium")) {
            buyPrice += 10;
        }
        if (p.getDifficulty().equals("Hard")) {
            buyPrice += 20;
        }
    }

    public Tower1(Player p, int x, int y) {
        this.atkDamage = 10;
        this.atkSpeed = 0.7;
        this.atkRange = 2;
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
        im.setX(50);
        im.setY(100);
        im.setFitWidth(100);
        im.setFitHeight(100);
        Text price = new Text();
        price.textProperty().bind(new SimpleStringProperty(("Price: ")).concat(
               new SimpleIntegerProperty(buyPrice).asString()));
        price.setX(70);
        price.setY(250);
        price.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        price.setFill(Color.BROWN);

        Text name = new Text(this.name);
        name.setX(70);
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
        /*if (p.getGold() < buyPrice) {
            continue;
        } else {
            atkDamage += 10;
            atkSpeed += 0.1;
            atkRange += 1;
        }*/
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
