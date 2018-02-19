package com.company;

public class paintWoodWith2Colors {
    public int solve(int n) {
        int[][] dp = new int[2][n + 1];
        dp[0][1] = 2;
        dp[1][2] = 2;
        for (int i = 0; i < 2; ++i) {
            for (int j = 2; j <= n; ++j) {
                if (j > 2) {
                    dp[1][j] = dp[0][j - 1];
                }
                dp[0][j] = dp[0][j - 1] + dp[1][j - 1];
            }
        }
        return dp[0][n] + dp[1][n];
    }
    public static void main(String[] args) {
        paintWoodWith2Colors solution = new paintWoodWith2Colors();
        System.out.println(solution.solve(4));
    }
}
