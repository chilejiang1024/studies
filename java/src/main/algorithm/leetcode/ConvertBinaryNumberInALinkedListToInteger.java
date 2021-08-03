package main.algorithm.leetcode;

import main.algorithm.leetcode.structure.ListNode;
import org.junit.Test;

/**
 * Description :
 *  <i>https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/</i>
 *  Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.
 *  Memory Usage: 36.3 MB, less than 85.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.
 *
 * @author chile
 * @version 1.0
 * @date 2021/8/3 10:09
 */
public class ConvertBinaryNumberInALinkedListToInteger {

    class Solution {

        public int getDecimalValue(ListNode head) {
            // remove all zeros in the lead
            while (head != null) {
                if (head.val == 0) {
                    head = head.next;
                } else {
                    break;
                }
            }

            // revert
            if (head == null) {
                return 0;
            }

            ListNode n1 = head, n2 = head.next, n3;
            n1.next = null;
            while (n2 != null) {
                n3 = n2.next;
                n2.next = n1;
                n1 = n2;
                n2 = n3;
            }
            head = n1;

            // sum
            int power = 0, decimal = 0;
            while (head != null) {
                decimal += head.val * Math.pow(2, power++);
                head = head.next;
            }

            return decimal;
        }

    }

    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        head.addNext(0).addNext(1).addNext(0);
        assert new Solution().getDecimalValue(head) == 10;
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(0);
        head.addNext(0).addNext(0).addNext(0);
        assert new Solution().getDecimalValue(head) == 0;
    }

}
