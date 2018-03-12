package com.company;

public class kthNumberFromSkippingWithDigit4 {
    public String solve(int k) {
        StringBuilder sb = new StringBuilder();
        while (k > 0) {
            int remains = k % 9;
            if (remains >= 4) {
                remains++;
            }
            sb.append(remains);
            k /= 9;
        }
        return new String(sb.reverse());
    }
    public static void main(String[] args) {
        kthNumberFromSkippingWithDigit4 solution = new kthNumberFromSkippingWithDigit4();
        System.out.println(solution.solve(36));
    }
}
