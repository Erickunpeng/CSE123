package com.ericzhang.homework.c0;

import java.util.Scanner;

/**
 * @author Eric Zhang
 * @version 1.0
 */

public class Client {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        AbstractStrategyGame game = new ConnectFour();

        while (!game.isGameOver()) {
            System.out.println(game);
            System.out.printf("Player %d's turn.\n", game.getNextPlayer());
            try {
                game.makeMove(console);
            } catch (IllegalArgumentException ex) {
                System.out.println("**Illegal move: " + ex.getMessage());
            }
        }
        System.out.println(game);
        System.out.printf("Player %d wins!\n", game.getWinner());
    }
}
