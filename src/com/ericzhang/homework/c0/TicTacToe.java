package com.ericzhang.homework.c0;

import java.util.Scanner;

/**
 * @author Eric Zhang
 * @version 1.0
 */

public class TicTacToe implements AbstractStrategyGame {
    private char[][] board;
    private boolean isXTurn;

    public TicTacToe() {
        board = new char[][]{{'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}};
        isXTurn = true;
    }

    public boolean isGameOver() {
        return getWinner() >= 0;
    }

    public int getWinner() {
        for (int i = 0; i < board.length; i++) {
            // check row i
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != '-') {
                return board[i][0] == 'X' ? 0 : 1;
            }

            // check col i
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != '-') {
                return board[0][i] == 'X' ? 0 : 1;
            }
        }

        // check diagonals
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != '-') {
            return board[0][0] == 'X' ? 0 : 1;
        }
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != '-') {
            return board[0][2] == 'X' ? 0 : 1;
        }

        return -1;
    }

    public int getNextPlayer() {
        return isXTurn ? 0 : 1;
    }

    public void makeMove(Scanner input) {
        char currPlayer = isXTurn ? 'X' : 'O';

        System.out.print("Row? ");
        int row = input.nextInt();
        System.out.print("Column? ");
        int col = input.nextInt();

        makeMove(row, col, currPlayer);
        isXTurn = !isXTurn;
    }

    private void makeMove(int row, int col, char player) {
        if (row < 0 || row >= board.length ||
                col < 0 || col >= board[0].length) {
            throw new IllegalArgumentException("Invalid board position: " + row + "," + col);
        }

        if (board[row][col] != '-') {
            throw new IllegalArgumentException("Space already occupied: " + row + "," + col);
        }

        board[row][col] = player;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                result += board[i][j] + " ";
            }
            result += "\n";
        }
        return result;
    }
}
