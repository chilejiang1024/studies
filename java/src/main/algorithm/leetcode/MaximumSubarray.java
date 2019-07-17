package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2019/7/16 13:32
 */
public class MaximumSubarray {

    class Solution {
        public int maxSubArray1(int[] nums) {
            int maxS = Integer.MIN_VALUE, tempS = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    tempS += nums[j];
                    maxS = Math.max(maxS, tempS);
                }
                tempS = 0;
            }
            return maxS;
        }

        public int maxSubArray(int[] nums) {
            int maxS = Integer.MIN_VALUE, tempS = 0;
            for (int num : nums) {
                tempS = Math.max(num, num + tempS);
                maxS = Math.max(maxS, tempS);
            }
            return maxS;
        }
    }

    @Test
    public void test1() {
        int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        assert new Solution().maxSubArray(nums) == 6;
    }

    @Test
    public void test2() {
        int[] nums = new int[] { -1 };
        assert new Solution().maxSubArray(nums) == -1;
    }
}
