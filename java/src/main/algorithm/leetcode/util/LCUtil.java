package main.algorithm.leetcode.util;

import main.algorithm.leetcode.structure.ListNode;

/**
 * Title : main.algorithm.leetcode.util <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2019/8/21 13:14
 */
public class LCUtil {

    public static ListNode createList5() {
        return createListWith(5);
    }

    public static ListNode createListWith(int capacity) {
        ListNode head = new ListNode(1);
        ListNode cursorNode = head;
        for (int i = 2; i <= capacity; i++) {
            cursorNode.next = new ListNode(i);
            cursorNode = cursorNode.next;
        }
        return head;
    }

    public static void outputList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode originHead = head;

        do {
            System.out.print(head.val);
            System.out.print(" ");
            head = head.next;
        } while (head != null);

        head = originHead;

        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = LCUtil.createListWith(5);
        outputList(head);
        outputList(head);
    }

}
