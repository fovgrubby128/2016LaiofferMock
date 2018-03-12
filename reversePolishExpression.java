package com.company;

import java.util.*;

public class reversePolishExpression {
    public double solve(List<String> list) {
        Deque<Double> value = new LinkedList<>();
        Set<String> symbol = new HashSet<>();
        symbol.add("+");
        symbol.add("-");
        symbol.add("*");
        symbol.add("/");
        for (String cur : list) {
            if (symbol.contains(cur)) {
                Double val1 = value.pollLast();
                Double val2 = value.pollLast();
                if (cur.equals("+")) {
                    value.offerFirst(val1 + val2);
                } else if (cur.equals("-")) {
                    value.offerFirst(val2 - val1);
                } else if (cur.equals("*")) {
                    value.offerFirst(val2 * val1);
                } else {
                    if (Double.compare(val1, 0) == 0) {
                        return Integer.MAX_VALUE;
                    }
                    value.offerFirst(val2 / val1);
                }
            } else {
                value.offerFirst(Double.parseDouble(cur));
            }
        }
        return value.peekFirst();
    }
    public List<String> transfer(String expression) {
        int idx = 0;
        Deque<String> valueQueue = new LinkedList<>();
        Deque<Character> signStack = new LinkedList<>();
        Map<Character, Integer> order = new HashMap<>();
        order.put('+', 0);
        order.put('-', 0);
        order.put('*', 1);
        order.put('/', 1);
        while (idx < expression.length()) {
            char c = expression.charAt(idx);
            if (isDigit(expression.charAt(idx))) {
                int ct = 0;
                while (idx < expression.length() && isDigit(expression.charAt(idx))) {
                    c = expression.charAt(idx);
                    ct = ct * 10 + (int) (c - '0');
                    idx++;
                }
                idx--;
                valueQueue.offerLast("" + ct);
            } else if (order.containsKey(c)) {
                while (!signStack.isEmpty() &&
                        order.get(signStack.peekFirst()) != null &&
                                order.get(signStack.peekFirst()) > order.get(c)) {
                    valueQueue.offerLast(String.valueOf(signStack.pollFirst()));
                }
                signStack.offerFirst(c);
            } else if (c == '(') {
                signStack.offerFirst(c);
            } else if (c == ')') {
                while (!signStack.peekFirst().equals('(')) {
                    valueQueue.offerLast(String.valueOf(signStack.pollFirst()));
                }
                signStack.pollFirst();
            }
            idx++;
        }
        while (!signStack.isEmpty()) {
            valueQueue.offerLast(String.valueOf(signStack.pollFirst()));
        }
        return new ArrayList<>(valueQueue);
    }
    public boolean isDigit(char c) {
        return c - '0' >= 0 && c -'0' <= 9;
    }
    public static void main(String[] args) {
        reversePolishExpression solution = new reversePolishExpression();
        String expression = "(4 - 1) * 24 + 1";
        List<String> list = solution.transfer(expression);
        System.out.println(solution.solve(list));
    }
}
