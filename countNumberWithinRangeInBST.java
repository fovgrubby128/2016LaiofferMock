package com.company;


public class countNumberWithinRangeInBST {
    public int solve(TreeNode root, int lb, int ub) {
        if (root == null) {
            return 0;
        }
        if (root.val > ub) {
            return solve(root.left, lb, ub);
        }
        if (root.val < lb) {
            return solve(root.right, lb, ub);
        }
        return 1 + solve(root.left, lb, ub) + solve(root.right, lb, ub);
    }
    public static void main(String[] args) {
        countNumberWithinRangeInBST solution = new countNumberWithinRangeInBST();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(17);
        root.right.left.left = new TreeNode(11);
        root.right.left.right = new TreeNode(14);
        System.out.println(solution.solve(root, 17, 19));
    }
}
