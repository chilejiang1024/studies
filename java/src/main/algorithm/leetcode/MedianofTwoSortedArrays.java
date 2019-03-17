package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 * <p> Runtime: 23 ms, faster than 99.17% of Java online submissions for Median of Two Sorted Arrays.
 * <p> Memory Usage: 48 MB, less than 90.63% of Java online submissions for Median of Two Sorted Arrays.
 * @author chile
 * @version 1.0
 * @date 2019-3-17 20:48:41
 */
public class MedianofTwoSortedArrays {

    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int l1 = nums1.length, l2 = nums2.length;

            int allNumsCount = l1 + l2;
            int p1, p2;
            if (allNumsCount % 2 == 1) {
                p1 = p2 = allNumsCount / 2;
            } else {
                p1 = allNumsCount / 2 - 1;
                p2 = p1 + 1;
            }

            if (l1 == 0) {
                return (nums2[p1] + nums2[p2]) / 2.0d;
            }
            if (l2 == 0) {
                return (nums1[p1] + nums1[p2]) / 2.0d;
            }

            int[] all = new int[allNumsCount];

            int i = 0, j = 0;
            while (i + j <= p2) {
                if (i < l1 && j < l2) {
                    if (nums1[i] <= nums2[j]) {
                        all[i + j] = nums1[i++];
                    } else {
                        all[i + j] = nums2[j++];
                    }
                } else if (i >= l1) {
                    all[i + j] = nums2[j++];
                } else {
                    all[i + j] = nums1[i++];
                }
            }

            return (all[p1] + all[p2]) / 2.0d;

        }
    }

    @Test
    public void test1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double medianSortedArrays = new Solution().findMedianSortedArrays(nums1, nums2);
        assert medianSortedArrays == 2.0d;
    }

    @Test
    public void test2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double medianSortedArrays = new Solution().findMedianSortedArrays(nums1, nums2);
        assert medianSortedArrays == 2.5d;
    }

}
