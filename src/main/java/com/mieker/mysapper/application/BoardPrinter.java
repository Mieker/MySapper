package com.mieker.mysapper.application;


import com.mieker.mysapper.application.board.Board;

public class BoardPrinter {

    public void printBoard(Board board) {
        int[][] boardArray = board.getBoard();
        for (int[] row : boardArray) {
            for (int i = 0; i < row.length; i++) {
                if (i == row.length - 1) {
                    System.out.print(row[i] + "\n");
                } else {
                    System.out.print(row[i] + " ");
                }
            }
        }
    }
}
