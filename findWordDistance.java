package com.company;

import java.security.InvalidParameterException;
import java.util.*;

public class findWordDistance {
    List<String> list;
    Map<String, List<Integer>> map;
    findWordDistance(List<String> list) {
        this.list = list;
        map = new HashMap<>();
        for (int i = 0; i < list.size(); ++i) {
            String cur = list.get(i);
            List<Integer> idxs = map.get(cur);
            if (idxs == null) {
                idxs = new ArrayList<>();
            }
            idxs.add(i);
            map.put(cur, idxs);
        }
    }
    public int cloestDistance (String a, String b){
        List<Integer> idxList1 = map.get(a);
        List<Integer> idxList2 = map.get(b);
        if (idxList1 == null || idxList2 == null) {
            return -1;
        }
        int idx1 = 0; int idx2 = 0;
        int res = Math.abs(idxList1.get(idx1) - idxList2.get(idx2));
        while (idx1 < idxList1.size() && idx2 < idxList2.size()) {
            res = Math.min(res, Math.abs(idxList1.get(idx1) - idxList2.get(idx2)));
            if (idxList1.get(idx1) < idxList2.get(idx2)) {
                idx1++;
            } else {
                idx2++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        List<String> list = Arrays.asList("the", "quick", "brown", "fox", "quick");
        findWordDistance solution = new findWordDistance(list);
        System.out.println(solution.cloestDistance("fox", "quick"));
        System.out.println(solution.cloestDistance("the", "brown"));
        System.out.println(solution.cloestDistance("the", "quick"));
    }
}
