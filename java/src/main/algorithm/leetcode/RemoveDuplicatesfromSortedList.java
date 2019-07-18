package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *   <p> Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
 *   <p> Memory Usage: 36.1 MB, less than 99.96% of Java online submissions for Remove Duplicates from Sorted List.
 * @author chile
 * @version 1.0
 * @date 2019/7/18 15:37
 */
public class RemoveDuplicatesfromSortedList {

    public class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {

            ListNode n = head;
            while (n != null) {
                if (n.next != null) {
                    if (n.val == n.next.val) {
                        n.next = n.next.next;
                    } else {
                        n = n.next;
                    }
                } else {
                    break;
                }
            }

            return head;
        }
    }

    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(2);
        head.next = n1;
        n1.next = n2;
        head = new Solution().deleteDuplicates(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
