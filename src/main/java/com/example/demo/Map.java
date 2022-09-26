package com.example.demo;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import java.util.List;

public class Map {
    private final int sizex = 20;
    private final int sizey = 20;
    //private ITower[][] towers;
    private boolean[][] path;
    private Tile[][] tiles;
    private List<IMonster> monsterArray;
    private static final Image GROUND_IMG = new Image("https://i.ibb.co/CzWDs7k/grass-Tile.png");
    private static final Image PATH_IMG = new Image("https://i.ibb.co/bLG4B2P/pathTile.png");

    public Map() {
        tiles = new Tile[sizex][sizey];
        //towers = new ITower[sizex][sizey];
        path = new boolean[sizex][sizey];
        initializePath();
    }

    public ITower getTower(int x, int y) {
        if (x < 0 || x >= sizex || y < 0 || y >= sizey) {
            throw new ArrayIndexOutOfBoundsException("x or y index is out of bounds.");
        } else if (tiles[x][y].getIsPath()) {
            throw new IllegalArgumentException("this position is a path.");
        } else if (tiles[x][y].getTower()[0] == null) {
            throw new IllegalArgumentException("this position does not have a tower.");
        } else {
            return tiles[x][y].getTower()[0];
        }
    }

    //public void addTower(ITower t, int x, int y) {
    //    if (x < 0 || x >= sizex || y < 0 || y >= sizey) {
    //        throw new ArrayIndexOutOfBoundsException("x or y index is out of bounds.");
    //    } else if (tiles[x][y].getIsPath()) {
    //        throw new IllegalArgumentException(
    //                "this position is a path, tower can not be placed here.");
    //    } else if (towers[x][y] != null) {
    //        throw new IllegalArgumentException("this position already has a tower.");
    //    } else {
    //        towers[x][y] = t;
    //    }
    //}
    //
    //public void removeTower(int x, int y) {
    //    if (x < 0 || x >= sizex || y < 0 || y >= sizey) {
    //        throw new ArrayIndexOutOfBoundsException("x or y index is out of bounds.");
    //    } else if (path[x][y]) {
    //        throw new IllegalArgumentException("this position is a path.");
    //    } else if (towers[x][y] == null) {
    //        throw new IllegalArgumentException("this position does not have a tower.");
    //    } else {
    //        towers[x][y] = null;
    //    }
    //}

    public void initializePath() {
        for (int i = 0; i < sizex; i++) {
            for (int j = 0; j < sizey; j++) {
                path[i][j] = false;
            }
        }
        for (int i = 1; i <= 18; i++) {
            path[i][4] = true;
            path[i][9] = true;
            path[i][14] = true;
        }

        for (int j = 0; j <= 3; j++) {
            path[1][j] = true;
        }

        for (int j = 10; j <= 13; j++) {
            path[1][j] = true;
        }

        for (int j = 5; j <= 8; j++) {
            path[18][j] = true;
        }

        for (int j = 15; j <= 16; j++) {
            path[18][j] = true;
        }

        for (int i = 0; i < sizex; i++) {
            for (int j = 0; j < sizey; j++) {
                tiles[i][j] = path[i][j] ? new Tile(j, i, true) : new Tile(j, i, false);
                GameScreen.getPane().getChildren().add(tiles[i][j]);
            }
        }
    }

    public Pane drawMap(Pane root) {
        for (int i = 0; i < sizex; i++) {
            for (int j = 0; j < sizey; j++) {
                //root.getChildren().add(tiles[i][j].getIV());
                if (tiles[i][j].getTower()[0] != null) {
                    tiles[i][j].getTower()[0].showTower(root);
                }
            }
        }
        return root;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    // Vincent draw tower method (Need a way to pass the coordinates into this method from screen)
    //    public void drawTower(int x, int y, String towerOption) {
    //        Image towerImg = null;
    //
    //        if (Objects.equals(towerOption, "L")) {
    //            towerImg = new Image("https://th.bing.com/th/id/R.fa8738188e95494dd042ba90968612c1" +
    //                    "?rik=O1pAAhzLOJa5vQ&riu=http%3a%2f%2fclipground.com%2fimages%" +
    //                    "2ftower-clipart-3.jpg&ehk=QucJz1IpqJpExu2D9CpzaC6B2pTOkPOtV2uEzt30s" +
    //                    "Xw%3d&risl=&pid=ImgRaw&r=0");
    //        } else if (Objects.equals(towerOption, "Black")) {
    //            towerImg = new Image("https://thumbs.dreamstime.com/b/sailor-lighthouse-character-cartoon-style" +
    //                    "-vector-illustration-sailor-lighthouse-character-carto" +
    //                    "on-style-123970184.jpg");
    //        } else {
    //            towerImg = new Image("https://thumbs.dreamstime.com/b/santa-traffic-cone-against-" +
    //                    "mascot-argaet-vector-illustration-131559662.jpg");
    //        }
    //
    //        ImageView tV = new ImageView();
    //        if (!path[x][y]) {
    //            tV.setImage(towerImg);
    //            tV.setX(x * 48);
    //            tV.setY(y * 48);
    //        } else {
    //            Alert alert = new Alert(Alert.AlertType.ERROR);
    //            alert.setTitle("Error");
    //            alert.setHeaderText("Invalid selection");
    //            alert.setContentText(alert.getContentText()
    //                    + "- Cannot place tower here!\n");
    //        }
    //    }
}
