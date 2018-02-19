// 00000
// 00011
// 01111
// 00111

package com.company;
public class theFirstColumnFirstOne {
    public int solve(int[][] arr) {
        int smallestIndex = arr[0].length;
        for (int i = 0; i < arr.length; ++i) {
            smallestIndex = Math.min(smallestIndex, helper(arr[i]));
        }
        return smallestIndex == arr[0].length ? -1 : smallestIndex;
    }
    public int helper(int[] arr) {
        if (arr[arr.length - 1] == 0) return arr.length;
        int left = 0; int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == 1) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        theFirstColumnFirstOne solution = new theFirstColumnFirstOne();
        int[][] arr = new int[][]{
                                {0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 1},
                                {0, 0, 0, 0, 0},
                                };
        System.out.println(solution.solve(arr));
    }
}
