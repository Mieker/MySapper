package com.mieker.mysapper.application.layout;

import com.mieker.mysapper.MySapperApplication;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;


public class MainMenuBar {

    private static final String GAME_MENU = "Game";
    private static final String NEW_GAME_ITEM = "New game";
    private static final String EXIT_GAME_ITEM = "Exit";
    private static final String ABOUT_MENU = "About";

    public MenuBar createMenuBar() {
        MenuBar menu = new MenuBar();

        Menu gameMenu = new Menu(GAME_MENU);
        MenuItem newGameItem = new MenuItem(NEW_GAME_ITEM);
        newGameItem.setOnAction(action -> newGame());
        MenuItem exitGame = new MenuItem(EXIT_GAME_ITEM);
        exitGame.setOnAction(action -> exitProgram());
        gameMenu.getItems().addAll(newGameItem, exitGame);

        Menu aboutMenu = new Menu(ABOUT_MENU);

        menu.getMenus().addAll(gameMenu, aboutMenu);

        return menu;
    }

    private void newGame() {
        MySapperApplication.setNewGame();
    }

    private void exitProgram() {
        System.exit(0);
    }
}
