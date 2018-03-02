package com.company;

import java.util.HashSet;
import java.util.Set;

/** 题目貌似是给定四个api, move(), turnLeft(), turnRight(), clean()
 *  如果机器人可以move()，则会往前移动一格，并且传回true，否则false
 *  要求机器人扫除所有可走空间
 */
public class sweepRobot {
    void turnLeft(){};
    void turnRight(){};
    boolean move(){ return true; }
    void clean(){};
    public void cleanRoom() {
        Set<String> visited = new HashSet<>();
        visited.add(0 + "+" + 0);
        dfs(0, 0, visited);
    }
    void turnBack() {
        turnLeft();
        turnLeft();
    }
    private void dfs(int i, int j, Set<String> visited) {
        clean();
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int k = 0; k < 4; ++k) {
            String cur = i + dir[k][0] + "+" + j + dir[k][1];
            if (!visited.contains(cur)) {
                if (move()) {
                    visited.add(cur);
                    dfs(i + dir[k][0], j + dir[k][1], visited);
                    turnBack();
                    move();
                    turnBack();
                }
            }
            turnRight();
        }
    }
}
