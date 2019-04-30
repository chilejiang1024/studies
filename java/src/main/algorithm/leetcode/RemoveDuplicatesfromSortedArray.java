package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2019/4/29 9:49
 */
public class RemoveDuplicatesfromSortedArray {

    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            int i = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    nums[++i] = nums[j];
                }
            }

            return i + 1;
        }
    }

    @Test
    public void test1() {
        int[] nums = {1, 2};
        assert new Solution().removeDuplicates(nums) == 2;
        for (int i : nums) {
            System.out.print(i);
        }
    }

    @Test
    public void test2() {
        int[] nums = {1, 1, 2, 2, 4, 5, 6, 6};
        assert new Solution().removeDuplicates(nums) == 5;
        for (int i : nums) {
            System.out.print(i);
        }
    }

}
