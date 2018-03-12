package com.company;

import java.util.HashSet;
import java.util.Set;

public class paintDifferntRoomWithBarrier {
    public void paint(char[][] floor) {
        char paint = 'A';
        for (int i = 0; i < floor.length; ++i) {
            for (int j = 0; j < floor[0].length; ++j) {
                if (floor[i][j] == '.') {
                    floor[i][j] = paint;
                    dfs(i, j, floor, paint);
                    paint++;
                }
            }
        }
    }
    public void dfs(int i, int j, char[][] floor, char paint) {
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int k = 0; k < 4; ++k) {
            int newi = i + dir[k][0];
            int newj = j + dir[k][1];
            if (newi >= 0 && newi < floor.length && newj >= 0 && newj < floor[0].length && floor[newi][newj] == '.') {
                floor[newi][newj] = paint;
                dfs(newi, newj, floor, paint);
            }
        }
    }
    public static void main(String[] args) {
        paintDifferntRoomWithBarrier solution = new paintDifferntRoomWithBarrier();
        char[][] floor = new char[][]{{'.', '#', '.', '.', '#'}, {'#', '#', '.', '#', '#'}, {'#', '#', '.', '#', '.'}};
        solution.paint(floor);
        for (int i = 0; i < floor.length; ++i) {
            for (int j = 0; j < floor[0].length; ++j) {
                System.out.print(floor[i][j] + " ");
            }
            System.out.println();
        }
    }
}
