package com.company;
// Suppose four colors are 1, 2, 3, 4
public class rainbowSort4Colors {
    public void solve(int[] arr) {
        int i = 0;
        int j = 0;
        int k = arr.length - 1;
        while (j <= k) {
            if (arr[j] == 1) {
                swap(arr, i, j);
                i++;
                j++;
            } else if (arr[j] == 2 || arr[j] == 3) {
                j++;
            } else {
                swap(arr, j, k);
                k--;
            }
        }
        while (i < k) {
            if (arr[i] == 2) {
                i++;
            } else {
                swap(arr, i, k);
                k--;
            }
        }
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        rainbowSort4Colors solution = new rainbowSort4Colors();
        int[] arr = new int[]{1,3,2,2,3,4,1,1,2,3,1,3};
        solution.solve(arr);
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + ", ");
        }
    }
}
