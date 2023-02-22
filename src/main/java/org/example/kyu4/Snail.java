package org.example.kyu4;

import java.util.ArrayList;
import java.util.List;

/**
 * Snail (4 kyu)
 * Given an n x n array, return the array elements arranged
 * from outermost elements to the middle element, traveling clockwise.
 * <p>
 * array = [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * snail(array) #=> [1,2,3,6,9,8,7,4,5]
 * For better understanding, please follow the numbers of the next array consecutively:
 * <p>
 * array = [[1,2,3],
 * [8,9,4],
 * [7,6,5]]
 * snail(array) #=> [1,2,3,4,5,6,7,8,9]
 * <p>
 * NOTE: The idea is not sort the elements from the lowest value to the highest;
 * the idea is to traverse the 2-d array in a clockwise snailshell pattern.
 * <p>
 * NOTE 2: The 0x0 (empty matrix) is represented as en empty array inside an array [[]].
 */
public class Snail {
    public static int[] snail(int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return new int[]{};
        }
        List<Integer> result = new ArrayList<>();
        int rowBegin = 0;
        int rowEnd = array.length - 1;
        int colBegin = 0;
        int colEnd = array[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                result.add(array[rowBegin][i]);
            }
            rowBegin++;
            for (int i = rowBegin; i <= rowEnd; i++) {
                result.add(array[i][colEnd]);
            }
            colEnd--;
            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    result.add(array[rowEnd][i]);
                }
            }
            rowEnd--;
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    result.add(array[i][colBegin]);
                }
            }
            colBegin++;
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
