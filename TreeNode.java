package com.company;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    int cost;
    char c;
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(char c, int cost) {
        this.c = c;
        this.cost = cost;
    }
}
