package com.company;

public class hanoi {
    public int hanoi(int n) {
        if (n == 1) {
            return 1;
        }
        int val = hanoi(n - 1);
        return 2 * val + 1;
    }
    public void hanoi(int from, int mid, int end, int n) {
        if (n <= 0) {
            return;
        }
        // 从原始位置移动到原来mid的位置
        hanoi(from, end, mid, n - 1);
        System.out.println(from + "->" + end);
        hanoi(mid, end, from, n - 1);
    }
    public static void main(String[] args) {
        hanoi hanoi = new hanoi();
        System.out.println(hanoi.hanoi(4));
        hanoi.hanoi(0, 1, 2, 4);
    }
}
