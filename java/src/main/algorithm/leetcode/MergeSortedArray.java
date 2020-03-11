package main.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2019/11/11 15:48
 */
public class MergeSortedArray {

    class Solution3 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            for (int i = 0; i < n; i++) {
                nums1[m + i] = nums2[i];
            }
            quickSort(nums1, 0, m + n - 1);
        }

        private void quickSort(int[] nums, int p, int r) {
            if (p < r) {
                int q = partition(nums, p, r);
                quickSort(nums, p, q - 1);
                quickSort(nums, q + 1, r);
            }

        }

        private int partition(int[] nums, int p, int r) {
            int x = nums[r];
            int i = p, j = p;
            for (; j < r; j++) {
                if (nums[j] <= x) {
                    exchange(nums, i, j);
                    i++;
                }
            }
            exchange(nums, i, r);
            return i;
        }

        private void exchange(int[] nums, int i, int j) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }

    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] result = new int[m + n];

            for (int i = 0, j = 0; i + j < result.length;) {
                if (i < m && j < n) {
                    if (nums1[i] > nums2[j]) {
                        result[i + j] = nums2[j++];
                    } else {
                        result[i + j] = nums1[i++];
                    }
                } else {
                    if (i < m) {
                        result[i + j] = nums1[i++];
                    }
                    if (j < n) {
                        result[i + j] = nums2[j++];
                    }
                }
            }

            System.arraycopy(result, 0, nums1, 0, m + n);
        }


        private void exchange(int[] nums, int i, int j) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }

    @Test
    public void test1() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        new Solution().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

}
