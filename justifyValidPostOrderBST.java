package com.company;

public class justifyValidPostOrderBST {
    public boolean solve(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return helper(arr, 0, arr.length - 1);
    }

    public boolean helper(int[] arr, int left, int right) {
        if (left >= right) {
            return true;
        }
        int lidx = left;
        while (lidx < right) {
            if (arr[lidx] > arr[right]) {
                break;
            } else if (arr[lidx] == arr[right]) {
                return false;
            } else {
                lidx++;
            }
        }
        int ridx = lidx;
        while (ridx < right) {
            if (arr[ridx] <= arr[right]) {
                return false;
            } else {
                ridx++;
            }
        }
        return helper(arr, left, lidx - 1) && helper(arr, lidx, right - 1);
    }

    public static void main(String[] args) {
        justifyValidPostOrderBST solution = new justifyValidPostOrderBST();
        int[] arr = new int[]{4, 6, 2};
        System.out.println(solution.solve(arr));
    }
}
