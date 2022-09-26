package com.example.demo;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Tile extends StackPane {
    private static final int TILE_SIZE = 48;
    private static final Image GROUND_IMG = new Image("https://i.ibb.co/CzWDs7k/grass-Tile.png");
    private static final Image PATH_IMG = new Image("https://i.ibb.co/bLG4B2P/pathTile.png");
    // private static final int X_TILES = 20;
    // private static final int Y_TILES = 20;
    private static Player player;

    private int x;
    private int y;
    private boolean isPath;
    private boolean hasTower;

    private ITower[] tower = new ITower[1]; // tower img is in here
    private ImageView tileImg;

    public Tile(int x, int y, boolean isPath) {
        this.x = x;
        this.y = y;
        this.isPath = isPath;
        this.hasTower = false;

        tileImg = new ImageView();
        tileImg.setImage(isPath ? PATH_IMG : GROUND_IMG);
        tileImg.setX(x * 48);
        tileImg.setY(y * 48);

        //      border.setStroke(Color.RED);
        //      text.setFont(Font.font(18));
        //      text.setText(isPath ? "Y" : "N");
        //      text.setVisible(true);

        getChildren().addAll(tileImg);
        setTranslateX(x * TILE_SIZE);
        setTranslateY(y * TILE_SIZE);
        this.setOnMouseClicked(e -> action());
    }

    public void action() {
        //System.out.println(player.getTower1());
        //System.out.println(player.getTower2());
        //System.out.println(player.getTower3());
        //System.out.println(player.getGold());

        //System.out.println(smouseEvent.getX);
        // case 1: is path
        // case 2: player did not buy tower
        // case 3: bought tower

        if (player.checkTower() != 0 && isPath) {
            // isPath OR player did not buy & press on empty tile
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Warning");
            alert.setContentText(alert.getContentText()
                    + "Can't place tower on path\n");
            alert.show();
        } else if (player.checkTower() != 0 && hasTower) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Warning");
            alert.setContentText(alert.getContentText()
                    + "Tower exists in current location\n");
            alert.show();
        } else if (player.checkTower() == 0 && hasTower) {
            // upgrade tower
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setHeaderText("Warning");
            alert2.setContentText(alert2.getContentText()
                    + "Please buy a tower first\n");
            alert2.show();
            //            tower[0].upgradeTower(player);
        } else if (player.checkTower() == 0 && !isPath) {
            // if did not buy tower, and press on tile with tower
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setHeaderText("Warning");
            alert2.setContentText(alert2.getContentText()
                    + "Please buy a tower first\n");
            alert2.show();
        } else if (player.checkTower() != 0 && !hasTower) {
            // if player DID buy tower, and press on empty tile
            int result = player.checkTower();

            if (result == 0) {
                return;
            } else if (result == 1) {
                tower[0] = new Tower1(player, x, y);
                player.setTower1(0);
            } else if (result == 2) {
                tower[0] = new Tower2(player, x, y);
                player.setTower2(0);
            } else if (result == 3) {
                tower[0] = new Tower3(player, x, y);
                player.setTower3(0);
            }

            this.hasTower = true;
            tower[0].showTower(GameScreen.getPane());
        }
    }

    public static void setPlayer(Player p) {
        player = p;
    }

    public boolean getIsPath() {
        return isPath;
    }

    public ITower[] getTower() {
        return tower;
    }

    public void setTileImg(ImageView iV) {
        this.tileImg = iV;
    }

    public ImageView getIV() {
        return tileImg;
    }
    public boolean getHasTower() {
        return hasTower;
    }

}
