package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *   <p> Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate List.
 *   <p> Memory Usage: 37.7 MB, less than 79.31% of Java online submissions for Rotate List.
 * @author chile
 * @version 1.0
 * @date 2019/8/19 17:12
 */
public class RotateList {

    public class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {

        public ListNode rotateRight(ListNode head, int k) {
            int length = 0;

            ListNode t = head;
            while (t != null) {
                length++;
                t = t.next;
            }

            if (length == 0) {
                return head;
            }

            k = k % length;
            if (k == 0) {
                return head;
            }

            int end = length - k - 1;

            t = head;
            ListNode start = null;
            for (int i = 0; i < length; i++) {
                if (i == end) {
                    i++;
                    start = t.next;
                    t.next = null;
                    t = start;
                }
                if (i == length - 1) {
                    t.next = head;
                }
                t = t.next;
            }

            return start;
        }
    }

    @Test
    public void test1() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode result = new Solution().rotateRight(n1, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

}
