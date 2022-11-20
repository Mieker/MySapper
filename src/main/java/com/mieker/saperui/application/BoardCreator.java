package com.mieker.saperui.application;

import com.mieker.saperui.application.board.Board;
import com.mieker.saperui.application.bomber.BombFiller;
import com.mieker.saperui.application.numbers.Numerator;

public class BoardCreator {

    public Board createBoard() {
        BoardPrinter boardPrinter = new BoardPrinter();
        Board board = new Board(16, 16);
        System.out.println("Empty board created");

        board.fulfillBoard();
        System.out.println("Board fulfilled by zeros");
        boardPrinter.printBoard(board);

        BombFiller bombFiller = new BombFiller();
        bombFiller.prepareBombsAddresses(16, 40);
        board.setBoard(bombFiller.putBombs(board));
        System.out.println("Bombs placed");
        boardPrinter.printBoard(board);

        Numerator numerator = new Numerator();
        numerator.placeBombsNumbers(board);
        System.out.println("Bombs counted and marked");
        boardPrinter.printBoard(board);

        return board;
    }
}
