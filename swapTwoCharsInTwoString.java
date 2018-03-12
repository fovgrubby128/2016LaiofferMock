package com.company;

import java.util.*;

/** Two operations:
 *  1. swap two adajacent chars
 *  2. swap first and last char
 */
public class swapTwoCharsInTwoString {
    public int solve(String a, String b) {
        if (a.length() != b.length()) {
            return -1;
        }
        Map<Character, Integer> ct = new HashMap<>();
        for (char c : a.toCharArray()) {
            Integer count = ct.get(c);
            if (count == null) {
                count = 0;
            }
            count += 1;
            ct.put(c, count);
        }
        int size = ct.size();
        for (char c : b.toCharArray()) {
            Integer count = ct.get(c);
            if (count == null || count == 0) {
                return -1;
            } else {
                count -= 1;
                if (count == 0) {
                    size--;
                }
                ct.put(c, count);
            }
        }
        if (size != 0) { return -1; }
        Set<String> visited = new HashSet<>();
        visited.add(a);
        Deque<String> queue = new LinkedList<>();
        queue.offerLast(a);
        int step = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; ++i) {
                String cur = queue.pollFirst();
                char[] arr = cur.toCharArray();
                for (int j = 0; j < arr.length - 1; ++j) {
                    swap(arr, j, j + 1);
                    String newStr = new String(arr);
                    if (newStr.equals(b)) {
                        return step + 1;
                    }
                    if (!visited.contains(newStr)) {
                        visited.add(newStr);
                        queue.offerLast(newStr);
                    }
                    swap(arr, j, j + 1);
                }
                swap(arr, 0, arr.length - 1);
                String newStr = new String(arr);
                if (newStr.equals(b)) {
                    return step + 1;
                }
                if (!visited.contains(newStr)) {
                    visited.add(newStr);
                    queue.offerLast(newStr);
                }
                swap(arr, 0, arr.length - 1);
            }
            step++;
        }
        return -1;
    }
    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        swapTwoCharsInTwoString solution = new swapTwoCharsInTwoString();
        String a = "abcc";
        String b = "ccab";
        System.out.println(solution.solve(a, b));
    }
}
