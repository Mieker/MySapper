package com.mieker.mysapper.model;

import com.mieker.mysapper.MySapperApplication;
import com.mieker.mysapper.application.Styller;
import com.mieker.mysapper.application.board.Board;
import com.mieker.mysapper.application.numbers.ZerosFinder;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;

public class ButtonCreator {

    Styller styller = new Styller();

    public MyButton createButton(int x, int y, Board board, GridPane grid) {
        MyButton button = new MyButton();
        button.setStatus(Status.COVERED);
        button.setX(x);
        button.setY(y);
        button.setMinSize(35, 35);
        button.setMaxSize(35, 35);
        button.setStyle("-fx-font-weight: 700");
        button.setHiddenValue(board.getBoard()[y][x]);
        button.setOnAction(e -> {
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
            Image mine = new Image("flag.png");
            ImageView mineView = new ImageView(mine);
            if (event.getButton() == MouseButton.SECONDARY) {
                if (button.getStatus().equals(Status.COVERED)) {
                    MySapperApplication.bombCounter --;
                    MySapperApplication.refreshLabelValue();
                    button.setStatus(Status.MARKED);
                    button.setGraphic(mineView);
                } else if (button.getStatus().equals(Status.MARKED)) {

                    button.setStatus(Status.GUESS);
                    button.setGraphic(null);
                    button.setText("?");
                    button.setStyle("-fx-font-weight: 700; ");
                } else if (button.getStatus().equals(Status.GUESS)) {
                    MySapperApplication.bombCounter ++;
                    MySapperApplication.refreshLabelValue();
                    button.setStatus(Status.COVERED);
                    button.setText("");
                }

            }
        });
        return button;
    }
}
