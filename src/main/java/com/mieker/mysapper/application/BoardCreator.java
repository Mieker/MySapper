package com.mieker.mysapper.application;

import com.mieker.mysapper.application.board.Board;
import com.mieker.mysapper.application.bomber.BombFiller;
import com.mieker.mysapper.application.numbers.Numerator;

public class BoardCreator {

    public Board createBoard(int boardSize, int numOfBombs) {
        Board board = new Board(boardSize, boardSize);

        board.fulfillBoard();

        BombFiller bombFiller = new BombFiller();
        bombFiller.prepareBombsAddresses(boardSize, numOfBombs);
        board.setBoard(bombFiller.putBombs(board));

        Numerator numerator = new Numerator();
        numerator.placeBombsNumbers(board);

        return board;
    }
}
