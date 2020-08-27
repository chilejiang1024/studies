package main.algorithm.leetcode;

import main.algorithm.leetcode.structure.ListNode;
import main.algorithm.leetcode.util.LCUtil;
import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *   Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle.
 *   Memory Usage: 39.5 MB, less than 83.68% of Java online submissions for Linked List Cycle.
 * @author chile
 * @version 1.0
 * @date 2020/8/27 15:14
 */
public class LinkedListCycle {

    /**
     * 快慢指针的方式查找链表中是否有环
     * 如果链表中有环的话, 当慢指针走到环起点的时候, 设快指针领先慢指针N个节点,
     * 每向前一步, 快慢指针的差距减小1为N-1, 当N-1 == 0时, 快慢指针相遇,
     * 即链表中存在环
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }

            ListNode slow = head, fast = head;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (slow == fast) {
                    return true;
                }
            }

            return false;
        }
    }

    @Test
    public void test1() {
        ListNode head = LCUtil.createListWith(4);
        head.next.next.next.next = head;
        assert new Solution().hasCycle(head);
    }

    @Test
    public void test2() {
        ListNode head = LCUtil.createListWith(4);
        assert !new Solution().hasCycle(head);
    }

}
