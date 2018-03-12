package com.company;

import java.util.*;

public class cheapestPriceDuringTheDay {
    class Point {
        boolean start;
        int time;
        int val;
        Point(boolean start, int time, int val) {
            this.val = val;
            this.start = start;
            this.time = time;
        }
    }
    public List<int[]> solve(List<int[]> input) {
        List<int[]> res = new ArrayList<>();
        List<Point> list = new ArrayList<>();
        for (int[] element : input) {
            Point start = new Point(true, element[0], element[2]);
            Point end = new Point(false, element[1], element[2]);
            list.add(start);
            list.add(end);
        }
        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.time == o2.time) {
                    if (o1.start && o2.start) {
                        return o1.val - o2.val;
                    } else if (o1.start) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
                return o1.time - o2.time;
            }
        });
        int curTime = -1;
        int curPrice = Integer.MAX_VALUE;
        Map<Integer, Integer> lateDel = new HashMap<>();
        PriorityQueue<Integer> minheap = new PriorityQueue<>(11);
        for (Point point : list) {
            int time = point.time;
            boolean isStart = point.start;
            int price = point.val;
            if (isStart) {
                minheap.offer(price);
            } else {
                Integer ct = lateDel.get(price);
                if (ct == null) {
                    ct = 0;
                }
                ct += 1;
                lateDel.put(price, ct);
                while (!minheap.isEmpty() && lateDel.containsKey(minheap.peek())) {
                    Integer topPrice = minheap.poll();
                    Integer count = lateDel.get(topPrice);
                    count -= 1;
                    if (count == 0) {
                        lateDel.remove(topPrice);
                    } else {
                        lateDel.put(topPrice, count);
                    }
                }
            }
            if (!minheap.isEmpty()) {
                Integer curSmallPrice = minheap.peek();
                if (curSmallPrice != curPrice) {
                    if (curPrice != Integer.MAX_VALUE) {
                        res.add(new int[]{curTime, time, curPrice});
                    }
                    curTime = time;
                    curPrice = curSmallPrice;
                }
            } else {
                if (curPrice != Integer.MAX_VALUE) {
                    res.add(new int[]{curTime, time, curPrice});
                }
                curTime = -1;
                curPrice = Integer.MAX_VALUE;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        cheapestPriceDuringTheDay solution = new cheapestPriceDuringTheDay();
        List<int[]> input = new ArrayList<>();
        input.add(new int[]{0, 4, 5});
        input.add(new int[]{0, 9, 4});
        input.add(new int[]{2, 8, 3});
        input.add(new int[]{8, 10, 3});
        input.add(new int[]{5, 9, 1});
        input.add(new int[]{7, 11, 10});
        List<int[]> res = solution.solve(input);
        for (int i = 0; i < res.size(); ++i) {
            int[] print = res.get(i);
            System.out.println("from " + print[0] + " to " + print[1] +": " + print[2]);
        }
    }
}
