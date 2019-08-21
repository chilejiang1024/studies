package main.algorithm.leetcode;

import main.algorithm.leetcode.structure.ListNode;
import main.algorithm.leetcode.util.LCUtil;
import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *   <P> Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
 *   <P> Memory Usage: 34.8 MB, less than 100.00% of Java online submissions for Remove Nth Node From End of List.
 * @author chile
 * @version 1.0
 * @date 2019/8/21 11:21
 */
public class RemoveNthFromEnd {

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode tempNode = head, prevNode = null, nextNode = null;

            int length = 0;
            while (tempNode != null) {
                length++;
                tempNode = tempNode.next;
            }

            int index = length - n;

            if (index == 0) {
                return head.next;
            } else {
                tempNode = head;
                for (int i = 0; i < length; i++) {
                    if (i == index - 1) {
                        prevNode = tempNode;
                    }
                    if (i == index) {
                        prevNode.next =  tempNode.next;
                        break;
                    }
                    tempNode = tempNode.next;
                }
            }

            return head;
        }
    }

    @Test
    public void test1() {

        for (int i = 1; i < 6; i++) {
            System.out.print("nth is: " + i + ", result: ");
            ListNode head = new Solution().removeNthFromEnd(LCUtil.createList5(), i);
            while (head != null) {
                System.out.print(head.val);
                head = head.next;
            }
            System.out.println();
        }
    }

}
