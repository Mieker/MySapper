package com.mieker.mysapper.application.numbers;

import com.mieker.mysapper.application.board.Board;

public class Numerator {

    int[][] boardToFill;

    public void placeBombsNumbers(Board board) {
        boardToFill = board.getBoard();

        for (int i = 0; i < board.getYSize(); i++) {
            for (int j = 0; j < board.getXSize(); j++) {
                if (boardToFill[i][j] != 9) {
                    boardToFill[i][j] = countNeighboursBombs(i, j);
                }
            }
        }
    }

    private int countNeighboursBombs(int x, int y) {
        int sum = 0;
        sum = getSum(x, y, sum, -1, -1);
        sum = getSum(x, y, sum, 0, -1);
        sum = getSum(x, y, sum, 1, -1);
        sum = getSum(x, y, sum, -1, 0);
        sum = getSum(x, y, sum, 1, 0);
        sum = getSum(x, y, sum, -1, 1);
        sum = getSum(x, y, sum, 0, 1);
        sum = getSum(x, y, sum, 1, 1);
        return sum;
    }

    private int getSum(int x, int y, int sum, int xMod, int yMod) {
        try {
            if (boardToFill[x + xMod][y + yMod] == 9) {
                sum++;
            }
        } catch (Exception e) {
        }
        return sum;
    }
}
