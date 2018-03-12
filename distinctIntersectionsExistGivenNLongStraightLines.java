package com.company;

import java.util.HashSet;
import java.util.Set;

/** Basic Idea:
 *  For nth line added, there are n situations: from all other lines not parallel to nth line to all parallel
 *  From each situation, the line(s) parallel would intersect with all other lines
 */
public class distinctIntersectionsExistGivenNLongStraightLines {
    public Set solve(int k) {
        Set[] dp = new Set[k + 1];
        dp[0] = new HashSet<Integer>();
        dp[0].add(0);
        for (int i = 1; i <= k; ++i) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < i; ++j) {
                Set<Integer> cur = dp[i - j - 1];
                for (Integer val : cur) {
                    set.add(val + (j + 1) * (i - j - 1));
                }
            }
            dp[i] = set;
        }
        return dp[k];
    }
    public static void main(String[] args) {
        distinctIntersectionsExistGivenNLongStraightLines solution = new distinctIntersectionsExistGivenNLongStraightLines();
        Set<Integer> set = solution.solve(6);
        for (Integer val : set) {
            System.out.print(val + " ");
        }
    }
}
