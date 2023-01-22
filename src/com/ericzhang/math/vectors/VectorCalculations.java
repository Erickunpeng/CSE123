package com.ericzhang.math.vectors;

/**
 * @author Eric Zhang
 * @version 1.0
 */

public class VectorCalculations {

    public static double dotProduct2D(Vector2D a, Vector2D b) {
        return a.getX() * b.getX() + a.getY() * b.getY();
    }

    public static double dotProduct3D(Vector3D a, Vector3D b) {
        return a.getX() * b.getX() + a.getY() * b.getY() + a.getZ() * b.getZ();
    }
}
