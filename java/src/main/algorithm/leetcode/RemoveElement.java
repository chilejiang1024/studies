package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 * <p> Runtime: 3 ms, faster than 100.00% of Java online submissions for Remove Element.
 * <p> Memory Usage: 37.6 MB, less than 90.60% of Java online submissions for Remove Element.
 * @author chile
 * @version 1.0
 * @date 2019/3/19 10:25
 */
public class RemoveElement {

    class Solution {
        public int removeElement(int[] nums, int val) {

            int h = 0, t = nums.length - 1, newLength = 0;

            while (true) {
                while (h <= t && nums[h] != val) {
                    newLength++;
                    h++;
                }
                while (h < t && nums[t] == val) {
                    t--;
                }
                if (h >= t) {
                    break;
                } else {
                    nums[h] = nums[t];
                    h++;
                    t--;
                    newLength++;
                }

            }

            return newLength;
        }
    }

    @Test
    public void test1() {
        int[] nums = {0, 2, 3, 1, 7, 9, 2};
        int val = 2;
        int leftNums = new Solution().removeElement(nums, val);
        assert leftNums == 5;
        for (int i = 0; i < leftNums; i++) {
            assert nums[i] != val;
        }
    }

    @Test
    public void test2() {
        int[] nums = {0, 2};
        int val = 2;
        int leftNums = new Solution().removeElement(nums, val);
        assert leftNums == 1;
        for (int i = 0; i < leftNums; i++) {
            assert nums[i] != val;
        }
    }

    @Test
    public void test3() {
        int[] nums = {0, 2};
        int val = 3;
        int leftNums = new Solution().removeElement(nums, val);
        assert leftNums == 2;
        for (int i = 0; i < leftNums; i++) {
            assert nums[i] != val;
        }
    }

}
