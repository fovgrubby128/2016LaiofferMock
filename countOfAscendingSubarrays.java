package com.company;

public class countOfAscendingSubarrays {
    public int solve(int[] arr) {
        int slow = 0;
        int fast = 1;
        int ct = 0;
        while (fast < arr.length) {
            if (arr[fast] > arr[fast - 1]) {
                fast++;
            } else {
                int gap = fast - slow;
                if (gap > 1) {
                    ct += (gap - 1) * gap / 2;
                }
                slow = fast;
                fast++;
            }
        }
        int gap = fast - slow;
        if (gap > 1) {
            ct += (gap - 1) * gap / 2;
        }
        return ct;
    }
    public static void main(String[] args) {
        countOfAscendingSubarrays solution = new countOfAscendingSubarrays();
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(solution.solve(arr));
    }
}
