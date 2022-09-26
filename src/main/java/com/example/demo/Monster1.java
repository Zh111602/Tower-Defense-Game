package com.example.demo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.concurrent.atomic.AtomicInteger;

public class Monster1 implements IMonster {
    private int health;
    private int movementSpeed;
    private double atkSpeed;
    private int atkDamage;
    private int atkRange;
    private int reward;
    private int x;
    private int y;
    private final Image image = new Image("https://i.pinimg.com"
            + "/originals/df/b7/17/dfb71789a47c71c7665fc241c0a6ab3c.png");
    public Monster1() {
        this.health = 50;
        this.movementSpeed = 10;
        this.x = 0;
        this.y = 50;
    }

    public Pane drawMonster(Pane root, Player player) {
        ImageView im = new ImageView(image);
        im.setX(x);
        im.setY(y);
        im.setFitWidth(48);
        im.setFitHeight(48);
        AtomicInteger i = new AtomicInteger();

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.1), actionEvent -> {
            i.getAndIncrement();
            if (player.getMonumentHP() > 0 && i.intValue() < 5) {
                x += 48;
                //y += 48;
                im.setX(x);
                //im.setY(y);
                System.out.println(player.getMonumentHP());
            }
            if (player.getMonumentHP() > 0 && i.intValue() >= 5 && i.intValue() <= 21) {
                //x += 48;
                y += 48;
                //im.setX(x);
                im.setY(y);
                System.out.println(player.getMonumentHP());
            }
            if (player.getMonumentHP() > 0 && i.intValue() >= 22 && i.intValue() <= 26) {
                x += 48;
                //y+= 48;
                im.setX(x);
                //im.setY(y);
                System.out.println(player.getMonumentHP());
            }
            if (player.getMonumentHP() > 0 && i.intValue() >= 27 && i.intValue() <= 43) {
                //x+= 48;
                y -= 48;
                //im.setX(x);
                im.setY(y);
                System.out.println(player.getMonumentHP());
            }
            if (player.getMonumentHP() > 0 && i.intValue() >= 44 && i.intValue() <= 48) {
                x += 48;
                //y+= 48;
                im.setX(x);
                //im.setY(y);
                System.out.println(player.getMonumentHP());
            }
            if (player.getMonumentHP() > 0 && i.intValue() >= 49 && i.intValue() <= 65) {
                //x+= 48;
                y += 48;
                //im.setX(x);
                im.setY(y);
                System.out.println(player.getMonumentHP());
            }
            if (player.getMonumentHP() > 0 && i.intValue() >= 66 && i.intValue() <= 69) {
                x += 48;
                //y+= 48;
                im.setX(x);
                //im.setY(y);
                System.out.println(player.getMonumentHP());
            }
            if (i.intValue() == 69) {
                player.setMonumentHP(player.getMonumentHP() - health);
                System.out.println(player.getMonumentHP());
                root.getChildren().remove(im);

            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        root.getChildren().addAll(im);

        return root;
    }

    public Monster1(int x, int y) {

    }

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

    public void setX(int num) {
        this.x = num;
    }
    @Override
    public int getY() {
        return y;
    }

    public void setY(int num) {
        this.y = num;
    }
}
