package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class mergeIntervals {
    static class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public List<Interval> solve(List<Interval> input) {
        Collections.sort(input, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        });
        Interval cur = null;
        List<Interval> ret = new ArrayList<>();
        for (Interval iter : input) {
            if (cur == null) {
                cur = iter;
            } else {
                if (cur.end < iter.start) {
                    ret.add(cur);
                    cur = iter;
                } else {
                    cur.end = Math.max(cur.end, iter.end);
                }
            }
        }
        ret.add(cur);
        return ret;
    }
    public static void main(String[] args) {
        mergeIntervals solution = new mergeIntervals();
        Interval a = new Interval(1, 3);
        Interval b = new Interval(2, 7);
        Interval c = new Interval(5, 10);
        Interval d = new Interval(6, 8);
        List<Interval> input = new ArrayList<>();
        input.add(a);
        input.add(b);
        input.add(c);
        input.add(d);
        List<Interval> res = solution.solve(input);
        for (Interval iter : res) {
            System.out.println("Interval|| start: " + iter.start + ", end: " + iter.end);
        }
    }
}
