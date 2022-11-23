package com.mieker.saperui.application.board;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class Board {
    private int xSize;
    private int ySize;
    private int[][] board;

    public Board(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.board = new int[ySize][xSize];
    }

    public void fulfillBoard() {
        Arrays.stream(board).forEach(a -> Arrays.fill(a, 0));
    }

}
