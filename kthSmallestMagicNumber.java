package com.company;

public class kthSmallestMagicNumber {
    public int solve(int n) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < 32; ++i) {
            if (((n >> i) & 1) == 1) {
                sum += count;
            }
            count *= 5;
        }
        return sum;
    }
    public static void main(String[] args) {
        kthSmallestMagicNumber solution = new kthSmallestMagicNumber();
        System.out.println(solution.solve(6));
    }
}
