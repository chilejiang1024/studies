package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *   <p> Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
 *   <p> Memory Usage: 39.9 MB, less than 14.47% of Java online submissions for Search in Rotated Sorted Array.
 * @author chile
 * @version 1.0
 * @date 2019/5/27 14:32
 */
public class SearchinRotatedSortedArray {

    class Solution {

        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            return search(nums, target, 0, nums.length - 1);
        }

        public int search(int[] nums, int target, int left, int right) {
            if (left > right) {
                return -1;
            }
            int pivot = (left + right) / 2;

            int index;
            if (nums[pivot] < nums[left]) {
                index = binarySearch(nums, target, pivot, right);
                if (index > -1) {
                    return index;
                } else {
                    return search(nums, target, left, pivot - 1);
                }
            } else {
                index = binarySearch(nums, target, left, pivot);
                if (index > -1) {
                    return index;
                } else {
                    return search(nums, target, pivot + 1, right);
                }
            }

        }

        public int binarySearch(int[] nums, int target, int left, int right) {
            if (left > right) {
                return -1;
            }
            int pivot = (left + right) / 2;
            if (nums[pivot] == target) {
                return pivot;
            } else if (target < nums[pivot]) {
                return binarySearch(nums, target, left, pivot - 1);
            } else {
                return binarySearch(nums, target, pivot + 1, right);
            }
        }

    }

    @Test
    public void binarySearchTest() {
        int[] nums = {1, 2, 3, 4};
        System.out.println(new Solution().binarySearch(nums, 1, 0, nums.length - 1));
        System.out.println(new Solution().binarySearch(nums, 2, 0, nums.length - 1));
        System.out.println(new Solution().binarySearch(nums, 3, 0, nums.length - 1));
        System.out.println(new Solution().binarySearch(nums, 4, 0, nums.length - 1));
    }

    @Test
    public void test1() {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println("my solution: " + new Solution().search(nums, 4) + ", answer: 0");
        System.out.println("my solution: " + new Solution().search(nums, 5) + ", answer: 1");
        System.out.println("my solution: " + new Solution().search(nums, 6) + ", answer: 2");
        System.out.println("my solution: " + new Solution().search(nums, 7) + ", answer: 3");
        System.out.println("my solution: " + new Solution().search(nums, 0) + ", answer: 4");
        System.out.println("my solution: " + new Solution().search(nums, 1) + ", answer: 5");
        System.out.println("my solution: " + new Solution().search(nums, 2) + ", answer: 6");
    }

    @Test
    public void test2() {
        int[] nums = { 5, 1, 3, 4 };
        System.out.println("my solution: " + new Solution().search(nums, 5) + ", answer: 0");
        System.out.println("my solution: " + new Solution().search(nums, 1) + ", answer: 1");
        System.out.println("my solution: " + new Solution().search(nums, 3) + ", answer: 2");
        System.out.println("my solution: " + new Solution().search(nums, 4) + ", answer: 2");
    }

    @Test
    public void test3() {
        int[] nums = { 9, 4, 5, 6, 7 };
        System.out.println("my solution: " + new Solution().search(nums, 1) + ", answer: -1");
        System.out.println("my solution: " + new Solution().search(nums, 2) + ", answer: -1");
        System.out.println("my solution: " + new Solution().search(nums, 4) + ", answer: 1");
    }
}
