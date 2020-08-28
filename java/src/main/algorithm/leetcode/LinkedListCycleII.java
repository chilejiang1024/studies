package main.algorithm.leetcode;

import main.algorithm.leetcode.structure.ListNode;
import main.algorithm.leetcode.util.LCUtil;
import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *   Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle II.
 *   Memory Usage: 39.2 MB, less than 97.37% of Java online submissions for Linked List Cycle II.
 * @author chile
 * @version 1.0
 * @date 2020/8/27 15:45
 */
public class LinkedListCycleII {

    /**
     * 设 a 为链表起点到环起点的距离
     *    b 为环起点到相遇点的距离
     *    c 为相遇点到环起点的另一半距离
     * 则有
     *    2(a + b) = a + b + c + b
     * 可得
     *    a = c
     * 即 链表起点到环起点距离 和 相遇点到起点距离相同
     * 另 两指针分别从 链表起点 和 相遇点 出发, 以相同速度前进, 则两指针相遇点为环起点
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }

            ListNode slow = head, fast = head;
            int countOfRing = 0;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    countOfRing = nodeCountOfRing(slow);
                    break;
                }
            }

            if (countOfRing > 0) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }

            return null;
        }

        public int nodeCountOfRing(ListNode node) {
            ListNode oneNode = node;
            int count = 1;
            node = node.next;
            while (oneNode != node) {
                node = node.next;
                count++;
            }
            return count;
        }
    }

    @Test
    public void test1() {
        ListNode head = LCUtil.createListWith(3);
        head.next.next.next = head;
        assert new Solution().detectCycle(head) == head;
    }

    @Test
    public void test2() {
        ListNode head = LCUtil.createListWith(3);
        assert new Solution().detectCycle(head) == null;
    }

    @Test
    public void test3() {
        ListNode head = LCUtil.createListWith(3);
        head.next.next.next = head.next;
        assert new Solution().detectCycle(head) == head.next;
    }

}
