package com.company;

public class maxPalindromeSubSequenceLength {
    public int solve(String str) {
        int[][] dp = new int[str.length()][str.length()];
        for (int i = dp.length - 1; i >= 0; --i) {
            for (int j = i; j < dp.length; ++j) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (i == j - 1) {
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? 2 : 1;
                } else {
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? dp[i + 1][j - 1] + 2 :
                            Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][str.length() - 1];
    }
    public static void main(String[] args) {
        maxPalindromeSubSequenceLength solution = new maxPalindromeSubSequenceLength();
        String str = "acdfhwerfwewasafsdferqgbasda";
        System.out.println(solution.solve(str));
    }
}
