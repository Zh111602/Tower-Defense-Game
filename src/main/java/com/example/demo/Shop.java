package com.example.demo;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class Shop {
    //private List<ITower> towerList;
    private final Image shopImage = new Image("https://th.bing.com/th/id/R.7abad091ed045e6fb3c9e76bb7b4ac27?rik=UlLiEhh%2bvsCYhA&riu=http%3a%2f%2ffreedesignfile.com%2fupload%2f2012%2f07%2f000b_134162855718135.jpg&ehk=Lq0D7Vqf%2bEQMgqdVhMY8GWaFLCeHnXz9xI8UWnMOy3U%3d&risl=&pid=ImgRaw&r=0");
    //private int x;
    //private int y;

    public Shop() {
        /*
        this.towerList = new ArrayList<>();
        towerList.add(new Tower1());
        towerList.add(new Tower2());
        towerList.add(new Tower3());
        */
    }

    public Pane drawShop(Pane root) {
        ImageView iV = new ImageView(shopImage);
        iV.setX(1100);
        iV.setY(70);
        iV.setFitWidth(100);
        iV.setFitHeight(100);
        root.getChildren().add(iV);

        /*for (IItems item:itemsList) {
            if (item instanceof MagicStone) {

                ImageView image = item.draw(6,8);
                root.getChildren().add(image);

                image.setPickOnBounds(true);
                image.setOnMouseClicked(new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Transaction Confimation");
                        alert.setResizable(false);
                        alert.setContentText("A Magic Stone costs you 10000 money.
                            Are you sure to buy it?");

                        Optional<ButtonType> result = alert.showAndWait();
                        ButtonType button = result.orElse(ButtonType.CANCEL);

                        if (button == ButtonType.OK) {
                            if (checkMoney(player, 10000)) {
                                //player.getCurrRoom().drawRoom(root, player);
                                System.out.println("You get a Magic Stone!");
                            }
                        } else {
                            System.out.println("Transaction canceled");
                        }
                    }
                });
            }
            else if (item instanceof HealthPotion) {
                ImageView image = item.draw(6,7);
                root.getChildren().add(image);

                image.setPickOnBounds(true);
                image.setOnMouseClicked(new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Transaction Confimation");
                        alert.setResizable(false);
                        alert.setContentText("A HealthPotion costs you 2000 money.
                            Are you sure to buy it?");

                        Optional<ButtonType> result = alert.showAndWait();
                        ButtonType button = result.orElse(ButtonType.CANCEL);

                        if (button == ButtonType.OK) {
                            if (checkMoney(player, 2000)) {
                                System.out.println("You get a HealthPotion!");
                                //player.getCurrRoom().drawRoom(root, player);
                            }
                        } else {
                            System.out.println("Transaction canceled");
                        }
                    }
                });
            }
            else if (item instanceof AttackPotion) {
                ImageView image = item.draw(6,6);
                root.getChildren().add(image);

                image.setPickOnBounds(true);
                image.setOnMouseClicked(new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Transaction Confimation");
                        alert.setResizable(false);
                        alert.setContentText("An AttackPotion costs you 2000 money.
                            Are you sure to buy it?");

                        Optional<ButtonType> result = alert.showAndWait();
                        ButtonType button = result.orElse(ButtonType.CANCEL);

                        if (button == ButtonType.OK) {
                            if (checkMoney(player, 2000)) {
                                System.out.println("You get an AttackPotion!");
                                //player.getCurrRoom().drawRoom(root, player);
                            }

                        } else {
                            System.out.println("Transaction canceled");
                        }
                    }
                });
            }
            else if (item instanceof Stick) {
                ImageView image = item.draw(7,6);
                root.getChildren().add(image);

                image.setPickOnBounds(true);
                image.setOnMouseClicked(new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Transaction Confimation");
                        alert.setResizable(false);
                        alert.setContentText("A Stick costs you 5000 money.
                            Are you sure to buy it?");

                        Optional<ButtonType> result = alert.showAndWait();
                        ButtonType button = result.orElse(ButtonType.CANCEL);

                        if (button == ButtonType.OK) {
                            if (checkMoney(player, 5000)) {
                                System.out.println("You get a Stick!");
                                //player.getCurrRoom().drawRoom(root, player);
                            }

                        } else {
                            System.out.println("Transaction canceled");
                        }
                    }
                });
            }
        }*/
        return root;
    }
}