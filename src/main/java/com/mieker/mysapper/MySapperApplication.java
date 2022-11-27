package com.mieker.mysapper;

import com.mieker.mysapper.application.BoardCreator;
import com.mieker.mysapper.application.Styller;
import com.mieker.mysapper.application.board.Board;
import com.mieker.mysapper.application.numbers.ZerosFinder;
import com.mieker.mysapper.model.MyButton;
import com.mieker.mysapper.model.Status;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.io.IOException;

public class MySapperApplication extends Application {

    static Board board;
    static GridPane grid;

    Styller styller = new Styller();

    @Override
    public void start(Stage primaryStage) throws IOException {
        BoardCreator boardCreator = new BoardCreator();
        board = boardCreator.createBoard();

        grid = new GridPane();
        int numRows = 16;
        int numColumns = 16;
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

        for (int i = 0; i < 16 * 16; i++) {
            MyButton button = createButton(i % 16, i / 16);

            grid.add(button, i % 16, i / 16);
        }

        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private MyButton createButton(int x, int y) {
        MyButton button = new MyButton();
        button.setStatus(Status.COVERED);
        button.setX(x);
        button.setY(y);
        button.setMinSize(35, 35);
        button.setMaxSize(35, 35);
        button.setStyle("-fx-font-weight: 700");
        button.setHiddenValue(board.getBoard()[y][x]);
        button.setOnAction(e -> {
            System.out.println("x: " + button.getX() + ", y: " + button.getY());
            System.out.println(button.getHiddenValue());
            if (button.getStatus().equals(Status.COVERED)) {
                button.setClicked(true);
                button.setStatus(Status.SHOWED);
                if (button.getHiddenValue() == 9) {
                    button.setText("x");
                    button.setStyle("-fx-font-weight: 700; -fx-background-color: #ff0000; ");

                } else if (button.getHiddenValue() == 0) {
                    button.setDisable(true);
                    ZerosFinder zerosFinder = new ZerosFinder();
                    zerosFinder.collectZerosCluster(board, grid, button.getX(), button.getY());
                } else {
                    button.setText(String.valueOf(button.getHiddenValue()));
                    button.setStyle(styller.setButtonColor(button.getHiddenValue()));

                }
            }
        });
        button.setOnMouseClicked(event -> {
            Image mine = new Image("mine.png");
            ImageView mineView = new ImageView(mine);
            if (event.getButton() == MouseButton.SECONDARY) {
                if (button.getStatus().equals(Status.COVERED)) {
                    button.setStatus(Status.MARKED);
                    button.setGraphic(mineView);
                } else if (button.getStatus().equals(Status.MARKED)) {
                    button.setStatus(Status.GUESS);
                    button.setGraphic(null);
                    button.setText("?");
                    button.setStyle("-fx-font-weight: 700; ");
                } else if (button.getStatus().equals(Status.GUESS)) {
                    button.setStatus(Status.COVERED);
                    button.setText("");
                }

            }
        });
        return button;
    }


    public static void main(String[] args) {
        launch();
    }
}