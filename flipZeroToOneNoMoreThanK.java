package com.company;

import java.util.Deque;
import java.util.LinkedList;

public class flipZeroToOneNoMoreThanK {
    public int solve(int[] arr, int k) {
        Deque<Integer> queue = new LinkedList<>();
        int fast = 0;
        int slow = 0;
        int maxLen = 0;
        while (fast < arr.length) {
            if (arr[fast] == 0) {
                queue.offerLast(fast);
                if (queue.size() > k) {
                    maxLen = Math.max(maxLen, fast - slow);
                    slow = queue.pollFirst() + 1;
                }
            }
            fast++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        flipZeroToOneNoMoreThanK solution = new flipZeroToOneNoMoreThanK();
        int[] arr = new int[]{1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0};
        System.out.println(solution.solve(arr, 1));
    }
}
