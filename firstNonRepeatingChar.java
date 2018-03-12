package com.company;

import java.util.*;

public class firstNonRepeatingChar {
    public Character solve(String str) {
        Map<Character, Integer> map = new HashMap<>();
        Deque<Character> queue = new LinkedList<>();
        for (char c : str.toCharArray()) {
            Integer ct = map.get(c);
            if (ct == null) {
                map.put(c, 1);
                queue.offerFirst(c);
            } else {
                map.put(c, ct + 1);
                while (!queue.isEmpty() && map.get(queue.peekLast()) != 1) {
                    queue.pollLast();
                }
            }
        }
        return queue.isEmpty() ? null : queue.peekLast();
    }

    public static void main(String[] args) {
        firstNonRepeatingChar solution = new firstNonRepeatingChar();
        String str = "abcbabc";
        System.out.println(solution.solve(str));
    }
}
