package com.company;

import java.util.Deque;
import java.util.LinkedList;

public class solve2SumInBST {
    public boolean solve(TreeNode root, int sum) {
        Deque<TreeNode> next = new LinkedList<>();
        Deque<TreeNode> prev = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null) {
            next.offerLast(cur);
            cur = cur.left;
        }
        cur = root;
        while (cur != null) {
            prev.offerLast(cur);
            cur = cur.right;
        }
        while (next.peekLast().val < prev.peekLast().val) {
            int smallValue = next.peekLast().val;
            int largeValue = prev.peekLast().val;
            if (smallValue + largeValue < sum) {
                moveForward(next);
            } else if (smallValue + largeValue > sum) {
                moveBackward(prev);
            } else {
                return true;
            }
        }
        return false;
    }

    public void moveForward(Deque<TreeNode> next) {
        TreeNode cur = next.pollLast();
        cur = cur.right;
        while (cur != null) {
            next.offerLast(cur);
            cur = cur.left;
        }
    }

    public void moveBackward(Deque<TreeNode> prev) {
        TreeNode cur = prev.pollLast();
        cur = cur.left;
        while (cur != null) {
            prev.offerLast(cur);
            cur = cur.right;
        }
    }

    public static void main(String[] args) {
        solve2SumInBST solution = new solve2SumInBST();
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
        System.out.println(solution.solve(root, 33));
    }
}
