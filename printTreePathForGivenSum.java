package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class printTreePathForGivenSum {
    public List<List<Integer>> solve(TreeNode root, int value) {
        Map<TreeNode, TreeNode> path = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<TreeNode> endList = new ArrayList<>();
        dfs(root, endList, path, 0, value);
        for (TreeNode cur : endList) {
            List<Integer> newList = new ArrayList<>();
            while (cur != null) {
                newList.add(cur.val);
                cur = path.get(cur);
            }
            res.add(newList);
        }
        return res;
    }
    public void dfs(TreeNode root, List<TreeNode> endList, Map<TreeNode, TreeNode> path, int sum, int value) {
        if (root.left == null && root.right == null) {
            if (sum + root.val == value) {
                endList.add(root);
            }
            return;
        }
        if (root.left != null) {
            path.put(root.left, root);
            dfs(root.left, endList, path, sum + root.val, value);
        }
        if (root.right != null) {
            path.put(root.right, root);
            dfs(root.right, endList, path, sum + root.val, value);
        }
    }
    public static void main(String[] args) {
        printTreePathForGivenSum solution = new printTreePathForGivenSum();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        List<List<Integer>> ans = solution.solve(root, 22);
        for (List<Integer> list : ans) {
            for (Integer cur : list) {
                System.out.print(cur + ", ");
            }
            System.out.println();
        }
    }
}
