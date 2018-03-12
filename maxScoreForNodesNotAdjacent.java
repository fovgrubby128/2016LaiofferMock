package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class maxScoreForNodesNotAdjacent {
    static class Node {
        int val;
        List<Node> children;
        Node(int val) {
            this.val = val;
            children = new ArrayList<>();
        }
    }
    public int solve(Node root) {
        int[] res = dfs(root);
        return res[1];
    }
    public int[] dfs(Node root) {
        if (root == null) {
            return new int[2];
        }
        List<int[]> res = new ArrayList<>();
        for (Node nei : root.children) {
            res.add(dfs(nei));
        }
        int[] ret = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int i = 0; i < res.size(); ++i) {
            ret[0] = ret[0] + res.get(i)[1];
            ret[1] = ret[1] + res.get(i)[0];
        }
        ret[1] = ret[1] + Math.max(0, root.val);
        return ret;
    }
    public static void main(String[] args) {
        maxScoreForNodesNotAdjacent solution = new maxScoreForNodesNotAdjacent();
        Node a = new Node(-1);
        Node b = new Node(-2);
        Node c = new Node(-2);
        Node d = new Node(-4);
        Node e = new Node(-3);
        Node f = new Node(-1);
        a.children = Arrays.asList(b, c);
        b.children = Arrays.asList(d, e);
        e.children = Arrays.asList(f);
        System.out.println(solution.solve(a));
    }
}
