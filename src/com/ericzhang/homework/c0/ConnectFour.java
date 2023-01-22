package com.ericzhang.homework.c0;

import java.util.Arrays;
import java.util.Scanner;

/**
 * A class to represent the game Connect Four
 */
public class ConnectFour implements AbstractStrategyGame {

    private final char[][] board;
    private boolean isRedTurn;

    /**
     * Creates a chessboard of 6 rows and 7 columns, and Red for the first step
     */
    public ConnectFour() {
        board = new char[6][7];
        for (char[] chars : board) {
            Arrays.fill(chars, '-');
        }
        isRedTurn = true;
    }

    /**
     * Gets the state of the current game
     *
     * @return A String object represents the state of the chessboard
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (char[] chars : board) {
            for (char aChar : chars) {
                result.append(aChar).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    /**
     * Finds if the game is over
     *
     * @return true is the game is over, false otherwise
     */
    @Override
    public boolean isGameOver() {
        return getWinner() >= 0;
    }

    /**
     * Gets the winner of the game
     *
     * @return 0 if the Red wins, 1 if the Yellow wins, -1 if the game is not over
     */
    @Override
    public int getWinner() {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char chess = board[i][j];

                // check for rows
                if (j < board[i].length - 3 && chess == board[i][j + 1]
                        && chess == board[i][j + 2] && chess == board[i][j + 3]
                        && chess != '-') {
                    return chess == 'R' ? 0 : 1;
                }

                // check for columns
                if (i < board.length - 3 && chess == board[i + 1][j]
                        && chess == board[i + 2][j] && chess == board[i + 3][j]
                        && chess != '-') {
                    return chess == 'R' ? 0 : 1;
                }

                // check for diagonal
                if (i < board.length - 3 && j < board[i].length - 3
                        && chess == board[i + 1][j + 1] && chess == board[i + 2][j + 2]
                        && chess == board[i + 3][j + 3] && chess != '-') {
                    return chess == 'R' ? 0 : 1;
                }
                // check for opposite diagonal direction
                if (i < board.length - 3 && j > 2 && chess == board[i + 1][j - 1]
                        && chess == board[i + 2][j - 2]
                        && chess == board[i + 3][j - 3] && chess != '-') {
                    return chess == 'R' ? 0 : 1;
                }
            }
        }

        // If the game is not over
        return -1;
    }

    /**
     * Gets the player for the next step in the game
     *
     * @return 0 if the Red is next, 1 if the Yellow is next, -1 if the game is over
     */
    @Override
    public int getNextPlayer() {
        if (isGameOver()) {
            return -1;
        }
        return isRedTurn ? 0 : 1;
    }

    /**
     * Gets the player's choice to remove a token or place a new token
     *
     * @param input The scanner to receive the choice of players
     */
    @Override
    public void makeMove(Scanner input) {
        char currPlayer = isRedTurn ? 'R' : 'Y';

        System.out.print("Do you want to remove or place? " +
                "(0 for remove, 1 for place a new token) ");
        int choice = input.nextInt();

        // Remove a bottom token
        if (choice == 0) {
            System.out.print("Column to remove? ");
            int removedCol = input.nextInt();
            remove(removedCol);
            isRedTurn = !isRedTurn;

            // Place a new token
        } else if (choice == 1) {
            System.out.print("Column to place a new token? ");
            int col = input.nextInt();
            makeMove(col, currPlayer);
            isRedTurn = !isRedTurn;

        } else {
            throw new IllegalArgumentException("Invalid choice: " + choice);
        }
    }

    /**
     * Remove the bottom token in column removedCol, and shift other tokens down
     *
     * @param removedCol The column to remove
     */
    private void remove(int removedCol) {
        // If the column is not in the range
        if (removedCol < 0 || removedCol >= board[0].length) {
            throw new IllegalArgumentException("Invalid board column: " + removedCol);
        }

        // If there's no token in the column
        if (board[board.length - 1][removedCol] == '-') {
            throw new IllegalArgumentException("The column is empty: " + removedCol);
        }

        // Remove the bottom token
        board[board.length - 1][removedCol] = '-';

        // Shifting other tokens down
        for (int i = board.length - 1; i > 0; i--) {
            board[i][removedCol] = board[i - 1][removedCol];
        }
        board[0][removedCol] = '-';
    }

    /**
     * Place a new token on the chessboard
     *
     * @param col    The column to place the token
     * @param player The player going to place the token, 'R' for Red, 'Y' for Yellow
     */
    private void makeMove(int col, char player) {
        // If the column is not in the range
        if (col < 0 || col >= board[0].length) {
            throw new IllegalArgumentException("Invalid board column: " + col);
        }

        int row = board.length - 1;
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] != '-') {
                row = i - 1;
                break;
            }
        }

        // If the column is full
        if (row == -1) {
            throw new IllegalArgumentException("The column is already occupied: " + col);
        }

        board[row][col] = player;
    }
}
