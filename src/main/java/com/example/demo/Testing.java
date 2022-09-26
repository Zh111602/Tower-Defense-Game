package com.example.demo;

import javafx.stage.Stage;
//import org.junit.Before;
import org.junit.Test;

//import java.io.IOException;
//import javafx.stage.Stage;
import org.testfx.framework.junit.ApplicationTest;
import static org.junit.Assert.assertEquals;
//import static org.testfx.api.FxAssert.verifyThat;
//import org.testfx.matcher.base.NodeMatchers;

public class Testing extends ApplicationTest {
    private static final int TIMEOUT = 200;

    @Override
    public void start(Stage primaryStage) throws Exception {
        WelcomePage start = new WelcomePage();
        start.start(primaryStage);
    }


    // Zhen Hong Tan
    // This checks if the player has selected a name and difficulty.
    // The player's name and difficulty should be according to the difficulty.
    @Test(timeout = TIMEOUT)
    public void testPlayerInitialization() {
        Player p = new Player("Name", "Easy");
        assertEquals("Name", p.getName());
        assertEquals("Easy", p.getDifficulty());
        assertEquals(300, p.getGold());
    }

    @Test(timeout = TIMEOUT)
    public void testPlayerInitialization2() {
        Player p = new Player("myName", "Hard");
        assertEquals("myName", p.getName());
        assertEquals("Hard", p.getDifficulty());
        assertEquals(100, p.getGold());
    }

    // Wei Sheng Tan
    // This checks the monument health according to the difficulty
    // Different difficulty should have different hp for the monument
    @Test
    public void testMonumentInitialization() {
        Monument m = new Monument();
        assertEquals(1, m.getX());
        assertEquals(1, m.getY());
    }

    @Test
    public void testMonumentInitialization1() {
        Monument m = new Monument();
        assertEquals(300, m.getHealth());
    }

    @Test(timeout = TIMEOUT)
    public void testMonumentInitialization2() {
        Player p = new Player("Name", "Hard");
        Monument m = new Monument("Hard");
        assertEquals(100, m.getHealth());
    }

    // Alvin Fabrio
    // checks the map initialization
    @Test(timeout = TIMEOUT)
    public void testMapInitialization() {

    }

    @Test(timeout = TIMEOUT)
    public void testTowerPurchase() {
        /*
        Tile t = new Tile(0, 0, true);
        t.action();
        assertEquals(false, t.getHasTower());
        */

    }

    // Vincent Chen
    // Check if a tower is placed in a slot (tile)
    // If a player chooses medium difficulty and purchases one tower 1,
    // a tower of type 1 must be added into the player's tower1 inventory.
    @Test(timeout = TIMEOUT)
    public void testTowerPurchase1() {
        Player p = new Player("Babi", "Medium");
        p.setTower1(1);
        assertEquals(1, p.getTower1());
    }

    // If a player chooses easy difficulty and purchases ten tower 2s,
    // ten towers of type 2 must be added into the player's tower2 inventory
    @Test(timeout = TIMEOUT)
    public void testTowerPurchase2() {
        Player p = new Player("Ichigo", "Easy");
        p.setTower2(10);
        assertEquals(10, p.getTower2());
    }

    // If a player chooses medium difficulty and purchases 2 tower 3s,
    // two towers of type 3 must be added into the player's tower1 inventory
    @Test(timeout = TIMEOUT)
    public void testTowerPurchase3() {
        Player p = new Player("Gon", "Medium");
        p.setTower3(2);
        assertEquals(200, p.getGold());
    }

    // If a player chooses easy difficulty and purchases no towers,
    // the player's gold should remain the same.
    @Test(timeout = TIMEOUT)
    public void testTowerPurchase4() {
        Player p = new Player("Killua", "Easy");
        p.setTower1(0);
        assertEquals(300, p.getGold());
    }

    @Test
    public void testStart() {
        //clickOn("Start");
        //verifyThat("Start a New Game", NodeMatchers.isNotNull());
    }

    @Test
    public void testScreen() {
        //clickOn("Quit");
        //verifyThat("Tech Tower Defense", NodeMatchers.isNotNull());
    }


}
