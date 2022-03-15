package main.algorithm.niuke;

import main.algorithm.niuke.data.ListNode;

/**
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2022/3/15 21:22
 */
public class BM4_Merge {

    public class Solution {

        public ListNode Merge(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }

            // merge list1 to list2
            ListNode h1, h2, head;
            if (list1.val <= list2.val) {
                head = list1;
                h1 = list1.next;
                h2 = list2;
            } else {
                head = list2;
                h1 = list1;
                h2 = list2.next;
            }
            while (true) {
                if (h1 == null) {
                    head.next = h2;
                    break;
                }
                if (h2 == null) {
                    head.next = h1;
                    break;
                }
                if (h1.val <= h2.val) {
                    head.next = h1;
                    h1 = h1.next;
                    head = head.next;
                } else {
                    head.next = h2;
                    h2 = h2.next;
                    head = head.next;
                }
            }
            return list1.val <= list2.val ? list1 : list2;
        }

    }

}
