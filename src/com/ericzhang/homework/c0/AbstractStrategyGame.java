package com.ericzhang.homework.c0;

import java.util.*;

/**
 * @author Eric Zhang
 * @version 1.0
 */

public interface AbstractStrategyGame {
    public String toString();
    public boolean isGameOver();
    public int getWinner();
    public int getNextPlayer();
    public void makeMove(Scanner input);
}
