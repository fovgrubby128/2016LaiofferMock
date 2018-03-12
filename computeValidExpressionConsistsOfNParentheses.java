package com.company;

public class computeValidExpressionConsistsOfNParentheses {
    public int solve(int n) {
        int[][] res = new int[n + 1][n + 1];
        for (int i = 0; i <= n; ++i) {
            for (int j = i; j <= n; ++j) {
                if (i == 0) {
                    res[i][j] = 1;
                } else {
                    res[i][j] = res[i - 1][j];
                    if (i != j) {
                        res[i][j] += res[i][j - 1];
                    }
                }
            }
        }
        return res[n][n];
    }
    public static void main(String[] args) {
        computeValidExpressionConsistsOfNParentheses solution = new computeValidExpressionConsistsOfNParentheses();
        System.out.println(solution.solve(10));
    }
}
