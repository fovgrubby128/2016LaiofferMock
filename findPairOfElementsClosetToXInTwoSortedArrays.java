package com.company;

public class findPairOfElementsClosetToXInTwoSortedArrays {
    public int[] solve(int[] a, int[] b, int x) {
        int aPoint = 0;
        int bPoint = b.length - 1;
        int[] res = new int[]{aPoint, bPoint};
        while (aPoint < a.length && bPoint >= 0) {
            int sum = a[aPoint] + b[bPoint];
            int bestSum = a[res[0]] + b[res[1]];
            if (Math.abs(sum - x) < Math.abs(bestSum - x)) {
                res[0] = aPoint;
                res[1] = bPoint;
            }
            if (sum == x) {
                return res;
            } else if (sum < x) {
                aPoint++;
            } else {
                bPoint--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        findPairOfElementsClosetToXInTwoSortedArrays solution = new findPairOfElementsClosetToXInTwoSortedArrays();
        int[] a = new int[]{1, 4, 5, 6};
        int[] b = new int[]{15, 21, 30, 50};
        int x = 32;
        int[] res = solution.solve(a, b, x);
        System.out.println(res[0] + ", " + res[1]);
    }
}
