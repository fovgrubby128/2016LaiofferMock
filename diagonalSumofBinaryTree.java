package com.company;

import java.util.HashMap;
import java.util.Map;

public class diagonalSumofBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public int[] solve(TreeNode root) {
        Map<Integer, Integer> record = new HashMap<>();
        int[] min = new int[1];
        helper(root, 0, record, min);
        int[] ret = new int[0 - min[0] + 1];
        for (int i = min[0]; i <= 0; ++i) {
            ret[i - min[0]] = record.get(i);
        }
        return ret;
    }
    public void helper(TreeNode root, int curIdx, Map<Integer, Integer> record, int[] min) {
        if (root == null) {
            return;
        }
        min[0] = Math.min(min[0], curIdx);
        Integer sum = record.get(curIdx);
        if (sum == null) {
            sum = 0;
        }
        sum += root.val;
        record.put(curIdx, sum);
        helper(root.left, curIdx - 1, record, min);
        helper(root.right, curIdx, record, min);
    }
    public static void main(String[] args) {
        diagonalSumofBinaryTree solution = new diagonalSumofBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(1);
        int[] res = solution.solve(root);
        for (int i = 0; i < res.length; ++i) {
            System.out.print(res[i] + " ");
        }
    }
}
