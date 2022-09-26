package com.example.demo;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameScreen {
    private int width;
    private int height;
    private Button back;
    private Button shop;
    private Button startWar;
    private static Pane root2;

    public GameScreen(int width, int height) {
        this.width = width;
        this.height = height;
        this.back = new Button("Quit");
        this.shop = new Button("Enter Shop");
        this.startWar = new Button("Start Combat");
        this.root2 = new Pane();
    }

    public Scene gameScene(Player player, Monument monument, Stage stage, Map map, Shop shopClass) {
        Tile.setPlayer(player);
        root2 = map.drawMap(root2);
        root2 = monument.drawMonument(root2);
        root2 = player.drawPlayerInfo(root2);
        root2 = shopClass.drawShop(root2);

        //GridPane root1 = new GridPane();
        //Button button1 = new Button("Purchase Tower here");
        //Button button2 = new Button("Purchase Tower here");
        //root1.getChildren().addAll(button1, button2);

        Scene scene2 = new Scene(root2, width, height);

        shop.setLayoutX(1100);
        shop.setLayoutY(30);
        startWar.setLayoutX(1100);
        startWar.setLayoutY(300);
        root2.getChildren().addAll(shop, back, startWar);

        return scene2;
    }

    public Button getBack() {
        return back;
    }

    public Button getShop() {
        return shop;
    }

    public Button getStartWar() { return startWar; }

    public static Pane getPane() {
        return root2;
    }
    public void setPane (Pane pane){
        this.root2 = pane;
    }
}

