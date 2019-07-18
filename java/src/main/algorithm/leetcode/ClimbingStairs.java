package main.algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *   <p> Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
 *   <p> Memory Usage: 32.7 MB, less than 5.19% of Java online submissions for Climbing Stairs.
 * @author chile
 * @version 1.0
 * @date 2019/7/18 10:49
 */
public class ClimbingStairs {

    class Solution {
        public int climbStairs(int n) {
            double sqrt5 = Math.sqrt(5);
            double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
            return (int) (fibn / sqrt5);
        }
    }

    class Solution1 {
        public int climbStairs(int n) {

            if (n < 4) {
                return n;
            }
            int[] dp = new int[n];
            dp[0] = 1;
            dp[1] = 2;
            for (int i = 2; i < n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n - 1];
        }
    }

    class Solution2 {
        Map<Integer, Integer> cache = new HashMap<>();

        public int climbStairs(int n) {
            if (n < 4) {
                return n;
            }

            if (cache.containsKey(n)) {
                return cache.get(n);
            }

            int s = climbStairs(n - 1) + climbStairs(n - 2);
            cache.put(n, s);

            return s;
        }
    }

    @Test
    public void test1() {
        assert new Solution().climbStairs(2) == 2;
    }

    @Test
    public void test2() {
        assert new Solution().climbStairs(3) == 3;
    }

    @Test
    public void test3() {
        assert new Solution().climbStairs(5) == 8;
    }
}
