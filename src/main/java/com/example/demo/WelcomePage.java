package com.example.demo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class WelcomePage extends Application {

    private final int width = 800;
    private final int height = 600;
    private Scene gameScene;
    private GameScreen gs;
    private Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {

        primaryStage = stage;

        Button quit = new Button("Quit");
        Button start = new Button("Start");

        StackPane root = new StackPane();

        Image background = new Image("https://wallpapercave.com/wp/wp4325537.jpg");
        ImageView backgroundImageView = new ImageView(background);


        backgroundImageView.setFitWidth(width);
        backgroundImageView.setFitHeight(height);
        root.getChildren().add(backgroundImageView);


        BorderPane welcomeScreen = new BorderPane();

        Label gameName = new Label("Tech Tower Defense");
        gameName.setAlignment(Pos.CENTER);
        Font titleFont = Font.loadFont("file:resources/OpenSans.ttf", 70);
        gameName.setStyle("-fx-text-fill: white; -fx-stroke: black;");
        gameName.setFont(titleFont);

        welcomeScreen.setTop(gameName);
        welcomeScreen.setAlignment(gameName, Pos.CENTER);
        welcomeScreen.setMargin(gameName, new Insets(50, 10, 10, 10));
        VBox buttons = new VBox(start, quit);
        buttons.setSpacing(20);
        start.getStyleClass().add("buttons");
        quit.getStyleClass().add("buttons");
        root.getChildren().add(welcomeScreen);
        buttons.setAlignment(Pos.CENTER);
        welcomeScreen.setCenter(buttons);
        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add("file:resources/WelcomeScreen.png");

        start.setOnAction(e -> {
            config();
        });

        quit.setOnAction(e -> {
            primaryStage.close();
        });


        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void config() {
        Label screenTitle = new Label("Start a New Game");
        screenTitle.getStyleClass().add("statusText");

        TextField nameInput = new TextField();
        ComboBox difficulty = new ComboBox<>();
        Button startButton = new Button("START");

        //NAME CREATION
        nameInput.setPromptText("Please Enter your name");
        nameInput.getStyleClass().add("nameInputText");
        Label name = new Label("Name:");
        name.getStyleClass().add("label");

        //DIFFICULTY SELECT
        difficulty.setPromptText("Please Select Your Difficulty");
        difficulty.getItems().addAll("Easy", "Medium", "Hard");
        Label diffLabel = new Label("Difficulty:");
        difficulty.getStyleClass().add("diffSelectBox");

        startButton.getStyleClass().add("startButton");

        startButton.setOnAction(e -> {
            try {
                if (nameInput.getText() == null || nameInput.getText().trim().isEmpty()
                        || difficulty.getValue() == null) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid selection");
                    if (nameInput.getText() == null || nameInput.getText().trim().isEmpty()) {
                        alert.setContentText("- Your name must include at least one character\n");
                    }
                    if (difficulty.getValue() == null) {
                        alert.setContentText(alert.getContentText()
                                + "- Please choose a difficulty\n");
                    }
                    alert.show();
                } else {
                    Player a = new Player(nameInput.getText(), (String) difficulty.getValue());
                    gameScreen(a);
                }


            } catch (Exception f) {
                f.printStackTrace();
            }
        });

        VBox vb1 = new VBox();
        vb1.getChildren().addAll(name, nameInput);
        vb1.getStyleClass().add("innerVBox");

        VBox vb2 = new VBox();
        vb2.getChildren().addAll(diffLabel, difficulty);
        vb2.getStyleClass().add("innerVBox");

        VBox motherVb = new VBox(screenTitle, vb1, vb2, startButton);

        motherVb.getStyleClass().add("outerVBox");

        HBox selectionsWrapper = new HBox(motherVb);
        selectionsWrapper.getStyleClass().add("outerHBox");

        BorderPane borderPane = new BorderPane(selectionsWrapper);
        borderPane.setId("pane");
        Scene scene = new Scene(borderPane, width, height);
        scene.getStylesheets().add("file:resources/InitialConfigScreen.css");

        primaryStage.setTitle("Configuration Screen");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void gameScreen(Player player) {
        gs = new GameScreen(width, height);
        Button back = gs.getBack();
        back.setOnAction(e -> {
            config();
        });
        Button shopButton = gs.getShop();
        shopButton.setOnAction(e -> {
            shopScreen(player);
        });
        Button startWar = gs.getStartWar();
        startWar.setOnAction(e -> {
            startWar(player, gameScene);
        });
        Map map = new Map();
        Monument monument = new Monument(player.getDifficulty());
        Shop shop = new Shop();
        gameScene = gs.gameScene(player, monument, primaryStage, map, shop);

        primaryStage.setTitle("Initial Game Screen");
        primaryStage.setScene(gameScene);
        primaryStage.show();
    }

    public void startWar(Player player, Scene scene1) {
        Monster1 m1 = new Monster1();
        Monster2 m2 = new Monster2();
        Monster3 m3 = new Monster3();

        Motion m = new Motion(player,gameScene, primaryStage, m1);

        Button back = gs.getBack();
        back.setOnAction(e -> {
            config();
        });
        Button shopButton = gs.getShop();
        shopButton.setOnAction(e -> {
            shopScreen(player);
        });
        m.warScene(gs.getPane(), player, m1, m2, m3);
        scene1.setRoot(gs.getPane());
        primaryStage.setTitle("Game Screen");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public void returnGameScene() {
        primaryStage.setTitle("Game Screen");
        primaryStage.setScene(gameScene);
        primaryStage.show();
    }

    public void shopScreen(Player player) {
        ShopScreenA screen = new ShopScreenA(width, height);
        Button back = screen.getBack();
        back.setOnAction(e -> {
            returnGameScene();
            /*primaryStage.setTitle("Game Screen");
            primaryStage.setScene(gameScene);
            primaryStage.show();
            gameScreen(player);*/
        });
        /*
        Button purchase = screen.getPurchaseButton();
        purchase.setOnAction( e -> {
            gameScreen(player);
        });

         */
        Tower1 t1 = new Tower1(player);
        Tower2 t2 = new Tower2(player);
        Tower3 t3 = new Tower3(player);

        Scene scene = screen.shopScreen(player, t1, t2, t3);

        primaryStage.setTitle("Shop Screen");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void placeTower(Player player) {

    }

    public class ShopScreenA {
        private int width;
        private int height;
        private Button back;
        private Stage primaryStage;

        public ShopScreenA(int width, int height) {
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
                            player.setTower1(player.getTower1() + 1);
                        }
                        if ((String) towerOption.getValue() == "Black Tower") {
                            price = t2.getBuyPrice();
                            player.setTower2(player.getTower2() + 1);
                        }
                        if ((String) towerOption.getValue() == "Rich Tower") {
                            price = t3.getBuyPrice();
                            player.setTower3(player.getTower3() + 1);
                        }

                        player.setGold(player.getGold() - price);
                        returnGameScene();

                        // NEED TO ADD A METHOD TO RECORD DOWN THE TOWERS OWNED BY THE PLAYER
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Congratulations");
                        alert.setHeaderText("Purchase complete");
                        alert.setContentText(alert.getContentText()
                            + "- Place the tower now!\n");
                        alert.show();
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

}


