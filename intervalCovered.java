package com.company;

import java.util.ArrayList;
import java.util.List;

public class intervalCovered {
    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    int area = 0;
    List<Interval> intervals = new ArrayList<>();
    public void add(Interval a) {
        List<Interval> list = new ArrayList<>();
        int curArea = 0;
        int idx = 0;
        while (idx < intervals.size()) {
            Interval cur = intervals.get(idx);
            if (cur.end < a.start) {
                idx++;
                curArea = cur.end - cur.start;
                list.add(cur);
            } else {
                break;
            }
        }
        if (idx == intervals.size()) {
            list.add(a);
            curArea += a.end - a.start;
            area = curArea;
            intervals = list;
            return;
        }
        Interval newInterval = intervals.get(idx);
        newInterval.start = Math.min(newInterval.start, a.start);
        newInterval.end = Math.max(newInterval.end, a.end);
        idx++;
        while (idx < intervals.size()) {
            Interval cur = intervals.get(idx);
            if (cur.start <= newInterval.end) {
                idx++;
                newInterval.end = Math.max(newInterval.end, cur.end);
            } else {
                break;
            }
        }
        curArea += newInterval.end - newInterval.start;
        list.add(newInterval);
        while (idx < intervals.size()) {
            Interval cur = intervals.get(idx);
            list.add(cur);
            idx++;
            curArea += cur.end - cur.start;
        }
        area = curArea;
        intervals = list;
    }
    public int coveredArea() {
        return area;
    }
    public static void main(String[] args) {
        intervalCovered solution = new intervalCovered();
        solution.add(new Interval(3, 6));
        solution.add(new Interval(8, 9));
        solution.add(new Interval(1, 5));
        solution.add(new Interval(10, 12));
        solution.add(new Interval(6, 8));
        solution.add(new Interval(6, 13));
        System.out.println(solution.coveredArea());
    }

}
