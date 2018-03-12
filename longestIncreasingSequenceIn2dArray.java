package com.company;

public class longestIncreasingSequenceIn2dArray {
    public int solve(int[][] arr) {
        int[][] res = new int[arr.length][arr[0].length];
        for (int i = 0; i < res.length; ++i) {
            for (int j = 0; j < res[0].length; ++j) {
                res[i][j] = -1;
            }
        }
        int max = 1;
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr[0].length; ++j) {
                if (res[i][j] == -1) {
                    res[i][j] = 1;
                    max = Math.max(max, dfs(res, arr, i, j));
                } else {
                    max = Math.max(max, res[i][j]);
                }
            }
        }
        return max;
    }
    public int dfs(int[][] res, int[][] arr, int i, int j) {
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int max = 0;
        for (int k = 0; k < 4; ++k) {
            int newi = i + dir[k][0];
            int newj = j + dir[k][1];
            if (newi >= 0 && newi < res.length && newj >= 0 && newj < res[0].length
                    && arr[newi][newj] < arr[i][j]) {
                if (res[newi][newj] == -1) {
                    res[newi][newj] = 1;
                    max = Math.max(max, dfs(res, arr, newi, newj));
                } else {
                    max = Math.max(max, res[newi][newj]);
                }
            }
        }
        res[i][j] = max + 1;
        return res[i][j];
    }
    public static void main(String[] args) {
        longestIncreasingSequenceIn2dArray solution = new longestIncreasingSequenceIn2dArray();
        int[][] arr = new int[][]{{1, 3, 6, 5}, {2, 7, 4, 6}, {12, 9 ,15 ,8}, {0, 14, 10, 11}};
        System.out.println(solution.solve(arr));
    }

}
