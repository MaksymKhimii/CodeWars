package khimii.example.kyu3;

import java.util.Arrays;

/**
 * Make a spiral (3 kyu)
 * Your task, is to create a NxN spiral with a given size.
 * <p>
 * For example, spiral with size 5 should look like this:
 * <p>
 * 00000
 * ....0
 * 000.0
 * 0...0
 * 00000
 * and with the size 10:
 * <p>
 * 0000000000
 * .........0
 * 00000000.0
 * 0......0.0
 * 0.0000.0.0
 * 0.0..0.0.0
 * 0.0....0.0
 * 0.000000.0
 * 0........0
 * 0000000000
 * Return value should contain array of arrays, of 0 and 1, with the first row being
 * composed of 1s. For example for given size 5 result should be:
 * <p>
 * [[1,1,1,1,1],[0,0,0,0,1],[1,1,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Because of the edge-cases for tiny spirals, the size will be at least 5.
 * <p>
 * General rule-of-a-thumb is, that the snake made with '1' cannot touch to itself.
 */
public class Spiralizor {
    public static int[][] spiralize(int size) {
        if (size < 5) {
            return null;
        }
        return spiralize(new int[size][size]);
    }

    public static int[][] spiralize(int[][] arr) {
        int[][] fill = fill(arr);

        final int height = fill.length;
        final int width = fill[0].length;
        int lastY = height / 2;
        int lastX = width % 2 == 0 ? width / 2 - 1 : width / 2;

        // Extra variants
        if (height == 5) {
            lastX = 1;
            lastY = 3;
        } else if ((height - 5) % 4 == 0) {
            lastX--;
            lastY++;
        }

        int y = 1, x = 0, dirX = 1, dirY = 0, i = 0;
        int leftBorder = 0, rightBorder = width - 1;
        int upperBorder = 0, lowerBorder = height - 1;

        while (true) {
            if (x == rightBorder && y == upperBorder + 1) {
                x--;
                y++;
                dirX = 0;
                dirY = 1;
                upperBorder += 2;
            } else if (x == leftBorder && y == lowerBorder - 1) {
                x++;
                y--;
                dirX = 0;
                dirY = -1;
                lowerBorder -= 2;
            } else if (y == lowerBorder && x == rightBorder - 1) {
                y--;
                x--;
                dirX = -1;
                dirY = 0;
                rightBorder -= 2;
            } else if (y == upperBorder && x == leftBorder + 1) {
                y++;
                x++;
                dirX = 1;
                dirY = 0;
                leftBorder += 2;
            }
            fill[y][x] = 0;

            if (y == lastY && x == lastX) {
                break;
            }

            x += dirX;
            y += dirY;
            i++;
        }

        return fill;
    }

    public static int[][] fill(int[][] arr) {
        for (int[] row : arr) {
            Arrays.fill(row, 1);
        }
        return arr;
    }
}