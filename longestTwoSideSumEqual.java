package com.company;

public class longestTwoSideSumEqual {
    public int[] solve(int[] arr) {
        int[] preSum = new int[arr.length + 1];
        int res = 0;
        int[] range = new int[]{-1, -1};
        for (int i = 1; i < preSum.length; ++i) {
            preSum[i] = preSum[i - 1] + arr[i - 1];
        }
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j <= i; ++j) {
                int length = i - j + 1;
                int start = i - 2 * length + 1;
                if (start >= 0) {
                    int total = preSum[i + 1] - preSum[start];
                    int right = preSum[i + 1] - preSum[j];
                    if (total == 2 * right && length * 2 > res) {
                        res = length * 2;
                        range[0] = start;
                        range[1] = i;
                    }
                }
            }
        }
        return range;
    }
    public static void main(String[] args) {
        longestTwoSideSumEqual solution = new longestTwoSideSumEqual();
        int[] arr = new int[]{1,2,4,1,5};
        int[] res = solution.solve(arr);
        System.out.println(res[0] + ", " + res[1]);
    }
}
