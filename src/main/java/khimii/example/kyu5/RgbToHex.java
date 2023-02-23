package khimii.example.kyu5;

import java.util.Locale;

/**
 * RGB To Hex Conversion (5 kyu)
 * The rgb function is incomplete.
 * Complete it so that passing in RGB decimal values
 * will result in a hexadecimal representation being returned.
 * Valid decimal values for RGB are 0 - 255.
 * Any values that fall out of that range must be rounded to the closest valid value.
 * <p>
 * Note: Your answer should always be 6 characters long,
 * the shorthand with 3 will not work here.
 * <p>
 * The following are examples of expected output values:
 * <p>
 * RgbToHex.rgb(255, 255, 255) // returns FFFFFF
 * RgbToHex.rgb(255, 255, 300) // returns FFFFFF
 * RgbToHex.rgb(0, 0, 0)       // returns 000000
 * RgbToHex.rgb(148, 0, 211)   // returns 9400D3
 */
public class RgbToHex {
    public static String rgb(int r, int g, int b) {
        r = Math.max(0, Math.min(255, r));
        g = Math.max(0, Math.min(255, g));
        b = Math.max(0, Math.min(255, b));
        String hexR = Integer.toHexString(r);
        String hexG = Integer.toHexString(g);
        String hexB = Integer.toHexString(b);
        hexR = hexR.length() < 2 ? "0" + hexR : hexR;
        hexG = hexG.length() < 2 ? "0" + hexG : hexG;
        hexB = hexB.length() < 2 ? "0" + hexB : hexB;
        return (hexR + hexG + hexB).toUpperCase(Locale.ROOT);
    }
}
