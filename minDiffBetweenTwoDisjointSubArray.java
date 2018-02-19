package com.company;

public class minDiffBetweenTwoDisjointSubArray {
    public int solve(int[] arr) {
        int maxDiff = 0;
        for (int i = 0; i < arr.length - 1; ++i) {
            int[] left = helper(arr, 0, i);
            int[] right = helper(arr, i + 1, arr.length - 1);
            maxDiff = Math.max(maxDiff, Math.max(Math.abs(left[1] - right[0]), Math.abs(left[0] - right[1])));
        }
        return maxDiff;
    }
    public int[] helper(int[] arr, int left, int right) {
        int[] ret = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        int maxSum = 0;
        int minSum = 0;
        for (int i = left; i <= right; ++i) {
            maxSum += arr[i];
            minSum += arr[i];
            ret[1] = Math.max(maxSum, ret[1]);
            ret[0] = Math.min(minSum, ret[0]);
            if (maxSum <= 0) {
                maxSum = 0;
            }
            if (minSum >= 0) {
                minSum = 0;
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        minDiffBetweenTwoDisjointSubArray solution = new minDiffBetweenTwoDisjointSubArray();
        int[] arr = new int[]{1, -3, 1, -4, 3, 4};
        System.out.println(solution.solve(arr));
    }
}
