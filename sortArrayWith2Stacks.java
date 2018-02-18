package com.company;

import java.util.Deque;
import java.util.LinkedList;

public class sortArrayWith2Stacks {
    public Deque<Integer> solve(Deque<Integer> stack) {
        Deque<Integer> stack2 = new LinkedList<>();
        while (!stack.isEmpty()) {
            Integer cur = stack.pollLast();
            int size = 0;
            while (!stack2.isEmpty() && stack2.peekLast() < cur) {
                stack.offerLast(stack2.pollLast());
                size++;
            }
            stack2.offerLast(cur);
            while (size > 0) {
                stack2.offerLast(stack.pollLast());
                size--;
            }
        }
        return stack2;
    }
    public static void main(String[] args) {
        sortArrayWith2Stacks solution = new sortArrayWith2Stacks();
        Deque<Integer> stack = new LinkedList<>();
        stack.offerLast(2);
        stack.offerLast(5);
        stack.offerLast(2);
        stack.offerLast(1);
        stack.offerLast(9);
        stack.offerLast(7);
        Deque<Integer> sorted = solution.solve(stack);
        while (!sorted.isEmpty()) {
            System.out.print(sorted.pollLast() + " ");
        }
    }
}
