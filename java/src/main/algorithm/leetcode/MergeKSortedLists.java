package main.algorithm.leetcode;

import main.algorithm.leetcode.structure.ListNode;
import main.algorithm.leetcode.util.LCUtil;
import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *   Runtime: 2 ms, faster than 94.10% of Java online submissions for Merge k Sorted Lists.
 *   Memory Usage: 45.3 MB, less than 6.53% of Java online submissions for Merge k Sorted Lists.
 * @author chile
 * @version 1.0
 * @date 2020/3/11 18:10
 */
public class MergeKSortedLists {

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (ListNode head : lists) {
                if (head == null) {
                    continue;
                }
                min = Math.min(min, head.val);
                while (head.next != null) {
                    head = head.next;
                }
                max = Math.max(max, head.val);
            }

            int numRange = max - min;
            if (numRange < 0) {
                return null;
            }

            int[] solts = new int[numRange + 1];

            for (ListNode head : lists) {
                if (head == null) {
                    continue;
                }
                do {
                    solts[head.val - min]++;
                    head = head.next;
                } while (head != null);
            }

            ListNode resultHead = null, tempNode = null;
            for (int i = 0; i < solts.length; i++) {
                if (solts[i] == 0) {
                    continue;
                }
                for (int j = 0; j < solts[i]; j++) {
                    ListNode node = new ListNode(i + min);
                    if (resultHead == null) {
                        resultHead = node;
                        tempNode = resultHead;
                    } else {
                        tempNode.next = node;
                        tempNode = node;
                    }
                }
            }

            return resultHead;
        }
    }

    @Test
    public void test1() {
        ListNode list1 = LCUtil.createListWith(3);
        ListNode list2 = LCUtil.createListWith(9);
        ListNode list3 = LCUtil.createListWith(6);
        ListNode[] lists = new ListNode[3];
        lists[0] = list1;
        lists[1] = list2;
        lists[2] = list3;
        ListNode node = new Solution().mergeKLists(lists);
        do {
            System.out.println(node.val);
            node = node.next;
        } while (node != null);

    }

    @Test
    public void test2() {
        ListNode list1 = LCUtil.createListWith(1);
        ListNode[] lists = new ListNode[3];
        lists[0] = list1;
        ListNode node = new Solution().mergeKLists(lists);
        do {
            System.out.println(node.val);
            node = node.next;
        } while (node != null);

    }

}
