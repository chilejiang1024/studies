package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *  <p> Runtime: 0 ms, faster than 100.00% of Java online submissions for Search Insert Position.
 *  <p> Memory Usage: 39.6 MB, less than 7.49% of Java online submissions for Search Insert Position.
 * @author chile
 * @version 1.0
 * @date 2019/4/29 14:46
 */
public class SearchInsertPosition {

    class Solution {
        public int searchInsert(int[] nums, int target) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums[0] > target) {
                return 0;
            }
            if (nums[nums.length - 1] < target) {
                return nums.length;
            }

            int i = 0;
            int j = nums.length / 2;
            int k = nums.length;
            while (i <= j) {
                if (target == nums[j]) {
                    return j;
                }
                if (target < nums[j]) {
                    i = 0;
                    k = j;
                    j = j / 2;
                }
                if (target > nums[j]) {
                    i = j + 1;
                    j = (k + j) / 2;
                }
            }
            return i;
        }
    }

    @Test
    public void test1() {
        int[] nums = { 1, 3, 5, 6 };
        int target = 5;
        assert new Solution().searchInsert(nums, target) == 2;
    }

    @Test
    public void test2() {
        int[] nums = { 1, 3, 5, 6 };
        int target = 2;
        assert new Solution().searchInsert(nums, target) == 1;
    }

    @Test
    public void test3() {
        int[] nums = { 2, 3, 5, 6, 9 };
        int target = 7;
        assert new Solution().searchInsert(nums, target) == 4;
    }

}
