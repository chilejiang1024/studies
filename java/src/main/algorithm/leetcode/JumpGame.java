package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *   <p> Runtime: 1 ms, faster than 99.80% of Java online submissions for Jump Game.
 *   <p> Memory Usage: 39.2 MB, less than 91.81% of Java online submissions for Jump Game.
 * @author chile
 * @version 1.0
 * @date 2019/6/19 14:31
 */
public class JumpGame {

    class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length, reach = 0;
            for (int i = 0; i < n; i++) {
                if (reach >= n - 1 || reach < i) {
                    break;
                }
                reach = Math.max(reach, i + nums[i]);
            }
            return reach >= n - 1;
        }
    }

    @Test
    public void test1() {
        int[] nums = { 2, 3, 1, 1, 4 };
        assert new Solution().canJump(nums);
    }

}
