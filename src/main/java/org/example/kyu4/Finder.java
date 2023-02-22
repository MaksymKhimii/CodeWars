package org.example.kyu4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Path Finder #2: shortest path (4kyu)
 * You are at position [0, 0] in maze NxN and you can only move in one of the four
 * cardinal directions (i.e. North, East, South, West).
 * Return the minimal number of steps to exit position [N-1, N-1]
 * if it is possible to reach the exit from the starting position.
 * Otherwise, return -1.
 *
 * Empty positions are marked .. Walls are marked W.
 * Start and exit positions are guaranteed to be empty in all test cases.
 */
public class Finder {
    public static int pathFinder(String maze) {
        String[] rows = maze.split("\n");
        int n = rows.length;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        dist[0][0] = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];
            if (r == n - 1 && c == n - 1) {
                return dist[r][c];
            }
            for (int[] dir : new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && rows[nr].charAt(nc) != 'W') {
                    int newDist = dist[r][c] + 1;
                    if (newDist < dist[nr][nc]) {
                        dist[nr][nc] = newDist;
                        queue.offer(new int[] {nr, nc});
                    }
                }
            }
        }
        return -1;
    }
}