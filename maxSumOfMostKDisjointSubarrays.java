package com.company;

public class maxSumOfMostKDisjointSubarrays {
    public int solve(int[] input, int k) {
        int[][] local = new int[input.length + 1][k + 1];
        int[][] global = new int[input.length + 1][k + 1];
        for (int i = 1; i <= input.length; ++i) {
            for (int j = 1; j <= k; ++j) {
                local[i][j] = Math.max(global[i - 1][j - 1], local[i - 1][j]) + input[i - 1];
                global[i][j] = Math.max(local[i][j], global[i - 1][j]);
            }
        }
        return global[input.length][k];
    }
    public static void main(String[] args) {
        maxSumOfMostKDisjointSubarrays solution = new maxSumOfMostKDisjointSubarrays();
        int[] input = new int[]{1, 5, 6, -2, -4, 6, -3, 2, 5, -9, 1, 5};
        int k = 2;
        System.out.println(solution.solve(input, k));
    }
}
