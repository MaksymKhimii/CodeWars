package khimii.example.kyu7;

/**
 * Greatest common divisor(7 kyu)
 * Find the greatest common divisor of two positive integers.
 * The integers can be large, so you need to find a clever solution.
 * <p>
 * The inputs x and y are always greater or equal to 1,
 * so the greatest common divisor will always be an integer
 * that is also greater or equal to 1.
 */
public class GCD {
    public static int compute(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}
