package com.mieker.saperui.application.bomber;

import com.mieker.saperui.application.board.Board;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BombFiller {

    Set<BombAddress> bombAddresses = new HashSet<>();

    public void prepareBombsAddresses(int boardSize, int numOfBombs) {
        while (bombAddresses.size() < numOfBombs) {
            bombAddresses.add(new BombAddress(xy(boardSize), xy(boardSize)));
        }
    }

    public int[][] putBombs(Board board) {
        int[][] tempBoard = board.getBoard();
        for (BombAddress entry : bombAddresses) {
            tempBoard[entry.getX()][entry.getY()] = 9;
        }
        return tempBoard;
    }

    private Integer xy(int boardSize) {
        return new Random().nextInt(boardSize);
    }
}
