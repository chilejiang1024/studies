package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *   <p> Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
 *   <p> Memory Usage: 33.6 MB, less than 100.00% of Java online submissions for Swap Nodes in Pairs.
 * @author chile
 * @version 1.0
 * @date 2019/5/24 17:06
 */
public class SwapNodesInPairs {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {

        public ListNode swapPairs(ListNode head) {
            if (head == null) {
                return head;
            }

            ListNode h = head.next == null ? head : head.next;

            ListNode p = null, n1, n2;
            while (head != null && head.next != null) {
                n1 = head.next;
                n2 = n1.next;
                n1.next = head;
                head.next = n2;
                if (p != null) {
                    p.next = n1;
                }
                p = head;
                head = n2;
            }
            return h;
        }
    }

    @Test
    public void test1() {
        ListNode t = new ListNode(1);
        ListNode t1 = new ListNode(2);
        ListNode t2 = new ListNode(3);
        ListNode t3 = new ListNode(4);
        t.next = t1;
        t1.next = t2;
        t2.next = t3;
        ListNode listNode = new Solution().swapPairs(t);
        assert listNode.val == 2;
        assert listNode.next.val == 1;
        assert listNode.next.next.val == 4;
        assert listNode.next.next.next.val == 3;
    }

    @Test
    public void test2() {
        ListNode t = new ListNode(1);
        ListNode t1 = new ListNode(2);
        ListNode t2 = new ListNode(3);
        t.next = t1;
        t1.next = t2;
        ListNode listNode = new Solution().swapPairs(t);
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

}
