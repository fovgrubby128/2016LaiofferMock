package com.company;

public class PrintFactors {
    public void solve(int k) {
        dfs(k, new StringBuilder(), k);
    }
    public void dfs(int k, StringBuilder sb, int lastAdd) {
        if (k == 1) {
            System.out.println(new String(sb));
            return;
        }
        int len = sb.length();
        for (int i = lastAdd; i > 1; --i) {
            if (k % i == 0) {
                if (len == 0) {
                    sb.append(i);
                } else {
                    sb.append(" * ");
                    sb.append(i);
                }
                dfs(k / i, sb, i);
                sb.delete(len, sb.length());
            }
        }
    }
    public static void main(String[] args) {
        PrintFactors solution = new PrintFactors();
        solution.solve(120);
    }
}
