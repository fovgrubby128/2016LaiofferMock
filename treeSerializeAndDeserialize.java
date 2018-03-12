package com.company;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class treeSerializeAndDeserialize {
    Map<Integer, Integer> pair = new HashMap<>();
    public String searlize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return new String(sb);
    }
    public void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            pair.put(sb.length(), sb.length() + 1);
            sb.append("()");
            return;
        }
        int curIdx = sb.length();
        sb.append("(");
        sb.append(root.val);
        dfs(root.left, sb);
        dfs(root.right, sb);
        pair.put(curIdx, sb.length());
        sb.append(")");
    }
    public TreeNode desearlize(String str) {
        return buildTree(str, 0, str.length() - 1);
    }
    public TreeNode buildTree(String str, int start, int end) {
        start++;
        end--;
        if (start > end) {
            return null;
        }
        int pos = 1;
        int idx = start;
        if (str.charAt(idx) == '-') {
            pos = -1;
            idx++;
        }
        int val = 0;
        while (idx <= end && isDigit(str.charAt(idx))) {
            val = 10 * val + (int) (str.charAt(idx) - '0');
            idx++;
        }
        TreeNode cur = new TreeNode(pos * val);
        int nextstart = pair.get(idx);
        cur.left = buildTree(str, idx, nextstart);
        cur.right = buildTree(str, nextstart + 1, end);
        return cur;
    }
    public boolean isDigit(char c) {
        return Character.isDigit(c);
    }
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }
    public static void main(String args[]) {
        treeSerializeAndDeserialize solution = new treeSerializeAndDeserialize();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right= new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        String express = solution.searlize(root);
        System.out.println(express);
        TreeNode newRoot = solution.desearlize(express);
        solution.inorder(newRoot);
    }
}
