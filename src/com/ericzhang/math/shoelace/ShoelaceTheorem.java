package com.ericzhang.math.shoelace;

import java.util.Arrays;
import java.util.List;

/**
 * @author Eric Zhang
 * @version 1.0
 */

public class ShoelaceTheorem {

    public static void main(String[] args) {
        Point A = new Point(-3, 0);
        Point B = new Point(-1, 4);
        Point C = new Point(6, 3);
        Point D = new Point(4, -1);

        System.out.println(ShoelaceTheorem.calculate(Arrays.asList(A, B, C, D)));

    }

    public static double calculate(List<Point> coordinates) {
        int num = coordinates.size();
        double sum = 0;

        for (int i = 0; i < num; i++) {
            if (i == num - 1) {
                sum += coordinates.get(i).getX() * coordinates.get(0).getY();
                sum -= coordinates.get(i).getY() * coordinates.get(0).getX();
            } else {
                sum += coordinates.get(i).getX() * coordinates.get(i + 1).getY();
                sum -= coordinates.get(i).getY() * coordinates.get(i + 1).getX();
            }
        }

        return Math.abs(sum) / 2;
    }
}


