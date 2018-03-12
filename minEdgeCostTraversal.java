package com.company;

public class minEdgeCostTraversal {
    public int solve(TreeNode root) {
        int[] res = dfs(root);
        return res[1];
    }
    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] res = new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        res[0] = left[0] + right[0] + (root.left != null ? root.left.cost * 2 : 0) + (root.right != null ? root.right.cost * 2 : 0);
        res[1] = Math.min(left[1] + right[0] + (root.left != null ? root.left.cost : 0) + (root.right != null ? root.right.cost * 2 : 0),
                left[0] + right[1] + (root.left != null ? root.left.cost * 2 : 0) + (root.right != null ? root.right.cost : 0));
        return res;
    }
    public static void main(String[] args) {
        minEdgeCostTraversal solution = new minEdgeCostTraversal();
        TreeNode root = new TreeNode('a', 0);
        root.left = new TreeNode('b', 3);
        root.left.left = new TreeNode('c', 2);
        root.left.right = new TreeNode('d', 1);
        root.right = new TreeNode('e', 2);
        root.right.left = new TreeNode('f', 3);
        root.right.right = new TreeNode('g', 4);
        System.out.println(solution.solve(root));
    }
}
