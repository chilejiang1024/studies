package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2019/5/24 14:03
 */
public class ContainerWithMostWater {

    class Solution {

        public int maxArea(int[] height) {
            int max = 0;
            int i = 0;
            int j = height.length - 1;

            while (i < j) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
                if (height[i] < height[j]) {
                    i++;
                } else {
                    j--;
                }
            }

            return max;
        }

    }

    @Test
    public void test1() {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        assert new Solution().maxArea(height) == 49;
    }

}
