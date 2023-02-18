package com.mieker.mysapper;

import com.mieker.mysapper.application.BoardCreator;
import com.mieker.mysapper.application.board.Board;
import com.mieker.mysapper.application.layout.MainMenuBar;
import com.mieker.mysapper.model.ButtonCreator;
import com.mieker.mysapper.model.MyButton;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

public class MySapperApplication extends Application {
    static Board board;
    static GridPane grid;
    static Label label = new Label();
    static ButtonCreator buttonCreator = new ButtonCreator();
    static BoardCreator boardCreator = new BoardCreator();
    static BorderPane borderPane = new BorderPane();

    static int boardSize = 10;
    static int numOfBombs = (boardSize * boardSize) / 6;
    public static int bombCounter = numOfBombs;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setResizable(false);
        primaryStage.setTitle("MySapper");

        MainMenuBar menu = new MainMenuBar();
        refreshLabelValue();

        borderPane.setTop(menu.createMenuBar());
        borderPane.setBottom(label);

        setNewGame();

        Scene scene = new Scene(borderPane);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void refreshLabelValue() {
        label.setText("Bombs left: " + String.valueOf(bombCounter));
    }

    public static void setNewGame() {
        board = boardCreator.createBoard(boardSize, numOfBombs);

        grid = new GridPane();
        int numRows = boardSize;
        int numColumns = boardSize;
        for (int row = 0; row < numRows; row++) {
            RowConstraints rc = new RowConstraints();
            rc.setFillHeight(true);
            rc.setVgrow(Priority.ALWAYS);
            grid.getRowConstraints().add(rc);
        }
        for (int col = 0; col < numColumns; col++) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setFillWidth(true);
            cc.setHgrow(Priority.ALWAYS);
            grid.getColumnConstraints().add(cc);
        }

        for (int i = 0; i < boardSize * boardSize; i++) {
            MyButton button = buttonCreator.createButton(i % boardSize, i / boardSize, board, grid);

            grid.add(button, i % boardSize, i / boardSize);
        }
        borderPane.setCenter(grid);

    }

    public static void main(String[] args) {
        launch();
    }
}