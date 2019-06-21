package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *   <p> Runtime: 2 ms, faster than 58.07% of Java online submissions for Jump Game II.
 *   <p> Memory Usage: 37.4 MB, less than 100.00% of Java online submissions for Jump Game II.
 * @author chile
 * @version 1.0
 * @date 2019/6/19 15:00
 */
public class JumpGameII {

    class Solution {
        public int jump(int[] nums) {
            int n = nums.length, reach = 0, currIndex = 0, nextIndex = 0, steps = 0;

            while (currIndex < n - 1) {
                for (int i = 0; i < nums[currIndex]; i++) {
                    if (currIndex + i + 1 >= n - 1) {
                        return ++steps;
                    }
                    if (reach < currIndex + i + 1 + nums[currIndex + i + 1]) {
                        nextIndex = currIndex + i + 1;
                        reach = currIndex + i + 1 + nums[currIndex + i + 1];
                    }
                }
                currIndex = nextIndex;
                reach = 0;
                steps++;
            }

            return steps;
        }
    }

    @Test
    public void test1() {
        int[] nums = { 2, 3, 1, 1, 4 };
        assert new JumpGameII.Solution().jump(nums) == 2;
    }

    @Test
    public void test2() {
        int[] nums = { 3, 2, 1 };
        assert new JumpGameII.Solution().jump(nums) == 1;
    }

    @Test
    public void test3() {
        int[] nums = { 0 };
        assert new JumpGameII.Solution().jump(nums) == 0;
    }

    @Test
    public void test4() {
        int[] nums = { 1, 2, 3 };
        assert new JumpGameII.Solution().jump(nums) == 2;
    }

    @Test
    public void test5() {
        int[] nums = { 1, 3, 2 };
        assert new JumpGameII.Solution().jump(nums) == 2;
    }

    @Test
    public void test6() {
        int[] nums = { 1, 2, 1, 1, 1 };
        assert new JumpGameII.Solution().jump(nums) == 3;
    }

}
