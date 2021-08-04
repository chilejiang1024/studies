package main.algorithm.leetcode;

import main.algorithm.leetcode.structure.ListNode;
import org.junit.Test;

/**
 * Description :
 *   <i>https://leetcode.com/problems/delete-node-in-a-linked-list/</i>
 *   Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a Linked List.
 *   Memory Usage: 38.2 MB, less than 74.67% of Java online submissions for Delete Node in a Linked List.
 *
 * @author chile
 * @version 1.0
 * @date 2021/8/4 10:31
 */
public class DeleteNodeInALinkedList {

    class Solution {

        public void deleteNode(ListNode node) {
            ListNode temp = node.next;
            node.val = node.next.val;
            node.next = node.next.next;
            temp = null;
        }

    }

    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        head.addNext(2).addNext(3);
        new Solution().deleteNode(head.next);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
