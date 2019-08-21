package main.algorithm.leetcode;

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

    public class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

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

    private ListNode createList() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        return n1;
    }

    @Test
    public void test1() {

        for (int i = 1; i < 6; i++) {
            System.out.print("nth is: " + i + ", result: ");
            ListNode head = new Solution().removeNthFromEnd(createList(), i);
            while (head != null) {
                System.out.print(head.val);
                head = head.next;
            }
            System.out.println();
        }
    }

}
