package com.company;

import java.util.Deque;
import java.util.LinkedList;

public class constructMaxSumPathFromTwoSortedLinkedList {
    public ListNode solve(ListNode a, ListNode b) {
        ListNode head = null;
        ListNode cur = null;
        while (a != null || b != null) {
            ListNode ahead = a;
            ListNode bhead = b;
            int suma = 0;
            int sumb = 0;
            while (a != null && b != null) {
                int vala = a.val;
                int valb = b.val;
                if (vala < valb) {
                    suma += vala;
                    a = a.next;
                } else if (vala > valb) {
                    sumb += valb;
                    b = b.next;
                } else {
                    break;
                }
            }
            if (a == null || b == null) {
                while (a != null) {
                   suma += a.val;
                   a = a.next;
                }
                while (b != null) {
                    sumb += b.val;
                    b = b.next;
                }
            }
            if (suma > sumb) {
                if (head == null) {
                    head = ahead;
                } else {
                    cur.next = ahead;
                }
                cur = a;
            } else {
                if (head == null) {
                    head = bhead;
                } else {
                    cur.next = bhead;
                }
                cur = b;
            }
            if (a != null) { a = a.next; }
            if (b != null) { b = b.next; }
        }
        return head;
    }
    public static void main(String[] args) {
        constructMaxSumPathFromTwoSortedLinkedList cMSPFTSLL = new constructMaxSumPathFromTwoSortedLinkedList();
        ListNode a = new ListNode(1);
        a.next = new ListNode(3);
        a.next.next = new ListNode(5);
        a.next.next.next = new ListNode(7);
        a.next.next.next.next = new ListNode(9);
        a.next.next.next.next.next = new ListNode(110);
        ListNode b = new ListNode(0);
        b.next = new ListNode(2);
        b.next.next = new ListNode(3);
        b.next.next.next = new ListNode(4);
        b.next.next.next.next = new ListNode(6);
        b.next.next.next.next.next = new ListNode(7);
        b.next.next.next.next.next.next = new ListNode(80);
        ListNode res = cMSPFTSLL.solve(a, b);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
