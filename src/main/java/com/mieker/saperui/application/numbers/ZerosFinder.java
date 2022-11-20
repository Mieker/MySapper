package com.mieker.saperui.application.numbers;

import com.mieker.saperui.model.MyButton;
import com.mieker.saperui.application.Styller;
import com.mieker.saperui.application.board.Board;
import com.mieker.saperui.model.Status;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import java.util.HashSet;
import java.util.Set;

public class ZerosFinder {

    Set<MyButton> zeroButtons = new HashSet<>();
    Set<MyButton> numberButtons = new HashSet<>();
    Board board;
    GridPane grid;
    Styller styller = new Styller();

    public void collectZerosCluster(Board board, GridPane grid, int x, int y) {
        this.board = board;
        this.grid = grid;

        findAllAdjacentZeros(x, y);

//        activateNumberButtons();
//        activateZeroButtons();
    }

    private void findAllAdjacentZeros(int x, int y) {
        detectNumber(x, y, -1, -1);
        detectNumber(x, y, 0, -1);
        detectNumber(x, y, 1, -1);

        detectNumber(x, y, -1, 0);
        detectNumber(x, y, 1, 0);

        detectNumber(x, y, -1, 1);
        detectNumber(x, y, 0, 1);
        detectNumber(x, y, 1, 1);
    }

//    public void activateNumberButtons() {
//        numberButtons.forEach(button -> {
//            int number = board.getBoard()[button.getY()][button.getX()];
//            button.setText(String.valueOf(number));
//        });
//    }

//    private void activateZeroButtons() {
//        zeroButtons.forEach(button -> {
//            findAllAdjacentZeros(button.getX(), button.getY());
//        });
//    }

    private void detectNumber(int x, int y, int xMod, int yMod) {
        int newX = x + xMod;
        int newY = y + yMod;
        int num = 0;
        try {
            num = board.getBoard()[newY][newX];
            MyButton button = (MyButton) getNodeByRowColumnIndex(newY, newX, grid);
            if (!button.isClicked()) {
                button.setClicked(true);
                button.setStatus(Status.SHOWED);
                if (num == 0) {
                    button.setDisable(true);
                    findAllAdjacentZeros(newX, newY);
                } else {
                    button.setText(String.valueOf(button.getHiddenValue()));
                    button.setStyle(styller.setButtonColor(button.getHiddenValue()));
                }
            }
        } catch (Exception e) {
        }
    }

    private Node getNodeByRowColumnIndex(final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> children = gridPane.getChildren();

        for (Node node : children) {
            if (gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }
        return result;
    }
}
