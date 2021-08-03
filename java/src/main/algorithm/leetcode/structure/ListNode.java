package main.algorithm.leetcode.structure;

/**
 * Title : main.algorithm.leetcode.structure <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2019/8/21 13:23
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode addNext(int num) {
        ListNode next = new ListNode(num);
        this.next = next;
        return next;
    }

}
