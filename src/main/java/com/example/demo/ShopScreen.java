package com.example.demo;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShopScreen {
    private int width;
    private int height;
    private Button back;
    private Stage primaryStage;

    public ShopScreen(int width, int height) {
        this.width = width;
        this.height = height;
        this.back = new Button("Quit Shop");
    }

    public Scene shopScreen(Player player, Tower1 t1, Tower2 t2, Tower3 t3) {
        Pane root = new Pane();
        root = t1.drawTower(root);
        root = t2.drawTower(root);
        root = t3.drawTower(root);
        Scene scene = new Scene(root, width, height);
        root.getChildren().add(back);

        Text showGold = new Text();
        showGold.textProperty().bind(new SimpleStringProperty(("Gold Left: ")).concat(
                new SimpleIntegerProperty(player.getGold()).asString()));
        showGold.setX(200);
        showGold.setY(30);
        showGold.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        showGold.setFill(Color.BROWN);
        root.getChildren().add(showGold);

        Text prompt = new Text("Select one to Purchase:");
        prompt.setX(230);
        prompt.setY(400);
        prompt.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        prompt.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        prompt.setFill(Color.BROWN);
        root.getChildren().add(prompt);

        TextField textInput = new TextField();
        ComboBox towerOption = new ComboBox<>();
        Button purchaseButton = new Button("Purchase");
        purchaseButton.setLayoutX(230);
        purchaseButton.setLayoutY(450);
        root.getChildren().add(purchaseButton);

        towerOption.setPromptText("Please Select One:");
        towerOption.getItems().addAll("Weak Tower", "Black Tower", "Rich Tower");
        towerOption.setLayoutX(230);
        towerOption.setLayoutY(410);
        root.getChildren().add(towerOption);

        purchaseButton.setOnAction(e -> {
            try {
                if (towerOption.getValue() == null
                        || ((String) towerOption.getValue() == "Weak Tower"
                        && player.getGold() < t1.getBuyPrice())
                        || ((String) towerOption.getValue() == "Black Tower"
                        && player.getGold() < t2.getBuyPrice())
                        || ((String) towerOption.getValue() == "Rich Tower"
                        && player.getGold() < t3.getBuyPrice())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid selection");
                    if (towerOption.getValue() == null) {
                        alert.setContentText(alert.getContentText()
                                + "- Please choose a tower to purchase\n");
                    } else {
                        alert.setContentText(alert.getContentText()
                                + "- You can't afford this!\n");
                    }
                    alert.show();
                } else {

                    int price = 0;

                    if ((String) towerOption.getValue() == "Weak Tower") {
                        price = t1.getBuyPrice();
                        //int num = player.getTower1() + 1;
                        // player.setTower1(1);
                    }
                    if ((String) towerOption.getValue() == "Black Tower") {
                        price = t2.getBuyPrice();
                        // player.setTower2(1);
                    }
                    if ((String) towerOption.getValue() == "Rich Tower") {
                        price = t3.getBuyPrice();
                        // player.setTower3(1);
                    }

                    player.setGold(player.getGold() - price);




                    // NEED TO ADD A METHOD TO RECORD DOWN THE TOWERS OWNED BY THE PLAYER

                    /*
                    // Display game screen again
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Congratulations");
                    alert.setHeaderText("Purchase complete");
                    alert.setContentText(alert.getContentText()
                            + "- Quit the shop to place tower!\n");
                   // alert.show();
                    */
                }
            } catch (Exception f) {
                f.printStackTrace();
            }
        });
        return scene;
    }


    public Button getBack() {
        return back;
    }

}






