package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *   <p> Merge two sorted linked lists and return it as a new list.
 *   <p> The new list should be made by splicing together the nodes of the first two lists.
 *   <p> Input: 1->2->4, 1->3->4
 *   <p> Output: 1->1->2->3->4->4
 *   <p> Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
 *   <p> Memory Usage: 37 MB, less than 97.90% of Java online submissions for Merge Two Sorted Lists.
 * @author chile
 * @version 1.0
 * @date 2019/4/25 13:42
 */
public class MergeTwoSortedLists {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;

            ListNode r = new ListNode(l1.val > l2.val ? l2.val : l1.val);

            ListNode rr = r;

            while (true) {
                if (l1 == null && l2 != null) {
                    r.next = l2;
                    break;
                }
                if (l1 != null && l2 == null) {
                    r.next = l1;
                    break;
                }
                if (l1 != null && l2 != null) {
                    if (l1.val > l2.val) {
                        r.next = l2;
                        r = r.next;
                        l2 = l2.next;
                    } else {
                        r.next = l1;
                        r = r.next;
                        l1 = l1.next;
                    }
                    continue;
                }
                if (l1 == null && l2 == null) {
                    break;
                }
            }

            return rr.next;
        }
    }

    @Test
    public void test1() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode r = new Solution().mergeTwoLists(l1, l2);
        while (r.next != null) {
            System.out.print(r.val);
            r = r.next;
        }
    }
}
