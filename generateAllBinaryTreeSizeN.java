package com.company;

import java.util.ArrayList;
import java.util.List;

public class generateAllBinaryTreeSizeN {
    public List<TreeNode> solve(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        TreeNode cur = new TreeNode(1);
        if (n == 1) {
            res.add(cur);
            return res;
        }
        for (int i = 0; i <= n - 1; ++i) {
            for (TreeNode left : solve(i)) {
                for (TreeNode right : solve(n - i)) {
                    cur = new TreeNode(1);
                    cur.left = left;
                    cur.right = right;
                    res.add(cur);
                }
            }
        }
        return res;
    }
}
