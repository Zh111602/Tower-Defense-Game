package com.example.demo;

//import model.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

public class Motion {
    private Player player;
    private Monster1 monster1;
    private Monster2 monster2;
    private Monster3 monster3;
    private Scene scene;
    private Stage stage;

    public Motion(Player player, Scene scene, Stage stage, Monster1 m1) {
        this.player = player;
        this.scene = scene;
        this.stage = stage;
        //this.draw = draw;
        this.monster1 = m1;
        this.monster2 = new Monster2();
        this.monster3 = new Monster3();
        //warScene(scene, player, monster1, monster2, monster3);
    }

    public Pane warScene(Pane root, Player p, Monster1 m1, Monster2 m2, Monster3 m3) {
        root = m3.drawMonster(root, p);
        return root;
    }

}
