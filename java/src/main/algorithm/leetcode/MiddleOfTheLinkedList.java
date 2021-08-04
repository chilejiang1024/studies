package main.algorithm.leetcode;

import main.algorithm.leetcode.structure.ListNode;
import org.junit.Test;

/**
 * Description :
 *   <i>https://leetcode.com/problems/middle-of-the-linked-list/</i>
 *   Runtime: 0 ms, faster than 100.00% of Java online submissions for Middle of the Linked List.
 *   Memory Usage: 36.2 MB, less than 80.01% of Java online submissions for Middle of the Linked List.
 *
 * @author chile
 * @version 1.0
 * @date 2021/8/4 9:52
 */
public class MiddleOfTheLinkedList {

    class Solution {

        public ListNode middleNode(ListNode head) {
            if (head == null) {
                return head;
            }

            ListNode s = head, f = head;
            while (f.next != null && f.next.next != null) {
                s = s.next;
                f = f.next.next;
            }

            return f.next == null ? s : s.next;
        }

    }

    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        head.addNext(2).addNext(3).addNext(4);
        assert new Solution().middleNode(head).val == 3;
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        assert new Solution().middleNode(head).val == 1;
    }

    @Test
    public void test3() {
        ListNode head = null;
        assert new Solution().middleNode(head) == null;
    }

    @Test
    public void test4() {
        ListNode head = new ListNode(1);
        head.addNext(2).addNext(3);
        assert new Solution().middleNode(head).val == 2;
    }

}
