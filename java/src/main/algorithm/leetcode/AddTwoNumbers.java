package main.algorithm.leetcode;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 * <p> Runtime: 19 ms, faster than 99.18% of Java online submissions for Add Two Numbers.
 * <p> Memory Usage: 48.5 MB, less than 5.08% of Java online submissions for Add Two Numbers.
 * @author chile
 * @version 1.0
 * @date 2019/3/15 13:30
 */
public class AddTwoNumbers {

    static class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode root = new ListNode(0);
            
            int carry = 0;
            ListNode tempNode = root;
            while (l1 != null || l2 != null || carry > 0) {
                int r = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
                int n = r % 10;
                carry = r / 10 > 0 ? r / 10 : 0;
                tempNode.next = new ListNode(n);
                tempNode = tempNode.next;
                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            }

            return root.next;
        }

    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;

        ListNode listNode = new Solution().addTwoNumbers(new ListNode(9), new ListNode(9));
        while (listNode != null) {
            System.out.print(listNode.val);
            System.out.print(" -> ");
            listNode = listNode.next;
        }
    }
}
