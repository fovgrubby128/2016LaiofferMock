package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class kthPermutation {
    public int[] solve(int[] arr, int k) {
        Arrays.sort(arr);
        int[] base = new int[arr.length - 1];
        for (int i = 0; i < base.length; ++i) {
            if (i == 0) { base[i] = 1; }
            else {
                base[i] = base[i - 1] * (i + 1);
            }
        }
        int j = base.length - 1;
        Set<Integer> visited = new HashSet<>();
        int[] res = new int[arr.length];
        int idx = 0;
        while (j >= 0) {
            int curIdx = (k - 1) / base[j];
            int time = curIdx;
            for (int i = 0; i < arr.length; ++i) {
                if (!visited.contains(i)) {
                    if (curIdx == 0) {
                        visited.add(i);
                        res[idx] = arr[i];
                        idx++;
                        break;
                    } else {
                        curIdx--;
                    }
                }
            }
            k -= time * base[j];
            j--;
        }
        for (int i = 0; i < arr.length; ++i) {
            if (!visited.contains(i)) {
                res[idx] = arr[i];
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        kthPermutation solution = new kthPermutation();
        int[] arr = new int[]{2, 5, 3, 1};
        for (int k = 1; k <= 12; ++k) {
            int[] res = solution.solve(arr, k);
            for (int i = 0; i < res.length; ++i) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }

}
