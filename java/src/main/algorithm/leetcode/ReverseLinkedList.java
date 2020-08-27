package main.algorithm.leetcode;

import main.algorithm.leetcode.structure.ListNode;
import main.algorithm.leetcode.util.LCUtil;
import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *   Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
 *   Memory Usage: 39.7 MB, less than 45.21% of Java online submissions for Reverse Linked List.
 * @author chile
 * @version 1.0
 * @date 2020/8/27 10:56
 */
public class ReverseLinkedList {

    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode n1 = head, n2 = head.next, n3 = n2.next;
            head.next = null;
            while (n3 != null) {
                n2.next = n1;
                n1 = n2;
                n2 = n3;
                n3 = n3.next;
            }
            n2.next = n1;

            return n2;
        }
    }

    @Test
    public void test1() {
        ListNode head = LCUtil.createListWith(9);
        LCUtil.outputList(head);
        ListNode newHead = new Solution().reverseList(head);
        LCUtil.outputList(newHead);
    }

    @Test
    public void test2() {
        ListNode head = LCUtil.createListWith(0);
        LCUtil.outputList(head);
        ListNode newHead = new Solution().reverseList(head);
        LCUtil.outputList(newHead);
    }

    @Test
    public void test3() {
        ListNode head = LCUtil.createListWith(1);
        LCUtil.outputList(head);
        ListNode newHead = new Solution().reverseList(head);
        LCUtil.outputList(newHead);
    }

    @Test
    public void test4() {
        ListNode head = LCUtil.createListWith(2);
        LCUtil.outputList(head);
        ListNode newHead = new Solution().reverseList(head);
        LCUtil.outputList(newHead);
    }

}
