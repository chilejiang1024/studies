package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *   Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
 *   Memory Usage: 42.9 MB, less than 99.29% of Java online submissions for Find First and Last Position of Element in Sorted Array.
 * @author chile
 * @version 1.0
 * @date 2020/3/30 15:44
 */
public class FirstAndLastPosition {

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
                return new int[] {-1, -1};
            }

            int n = nums.length, p = (n - 1) / 2, f = -1, l = -1, i = 0, j = n - 1;

            while (i <= j) {
                if (nums[p] > target) {
                    if (p > 0) {
                        if (nums[p - 1] < target) {
                            break;
                        }
                    }
                    j = p - 1;
                    p = (i + j) / 2;
                } else if (nums[p] < target) {
                    if (p < n - 1) {
                        if (nums[p + 1] > target) {
                            break;
                        }
                    }
                    i = p + 1;
                    p = (i + j) / 2;
                } else {
                    f = l = p;
                    while (f - 1 >= 0) {
                        if (nums[f - 1] == target) {
                            f--;
                        } else {
                            break;
                        }
                    }
                    while (l + 1 < n) {
                        if (nums[l + 1] == target) {
                            l++;
                        } else {
                            break;
                        }
                    }
                    break;
                }
            }

            return new int[] {f, l};
        }
    }

    @Test
    public void test1() {
        int[] nums = {5,7,7,8,8,10};
        int[] result = new Solution().searchRange(nums, 0);
        assert result[0] == -1;
        assert result[1] == -1;
    }

    @Test
    public void test2() {
        int[] nums = {5,7,7,8,8,10};
        int[] result = new Solution().searchRange(nums, 8);
        assert result[0] == 3;
        assert result[1] == 4;
    }

    @Test
    public void test3() {
        int[] nums = {5,7,7,8,8,10};
        int[] result = new Solution().searchRange(nums, 6);
        assert result[0] == -1;
        assert result[1] == -1;
    }

    @Test
    public void test4() {
        int[] nums = {0,0,1,1,1,4,5,5};
        int[] result = new Solution().searchRange(nums, 2);
        assert result[0] == -1;
        assert result[1] == -1;
    }

    @Test
    public void test5() {
        int[] nums = {0};
        int[] result = new Solution().searchRange(nums, 0);
        assert result[0] == 0;
        assert result[1] == 0;
    }

}
