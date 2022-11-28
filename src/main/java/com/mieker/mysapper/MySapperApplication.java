package com.mieker.mysapper;

import com.mieker.mysapper.application.BoardCreator;
import com.mieker.mysapper.application.board.Board;
import com.mieker.mysapper.application.layout.MainMenuBar;
import com.mieker.mysapper.model.ButtonCreator;
import com.mieker.mysapper.model.MyButton;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MySapperApplication extends Application {
    Board board;
    GridPane grid;
    ButtonCreator buttonCreator = new ButtonCreator();
    int boardSize = 10;
    int numOfBombs = (boardSize * boardSize) / 6;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setResizable(false);
        primaryStage.setTitle("MySapper");
        BoardCreator boardCreator = new BoardCreator();
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

        BorderPane borderPane = new BorderPane(grid);
        MainMenuBar menu = new MainMenuBar();

        borderPane.setTop(menu.createMenuBar());

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}