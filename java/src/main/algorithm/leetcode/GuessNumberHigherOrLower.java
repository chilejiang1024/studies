package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *   Runtime: 0 ms, faster than 100.00% of Java online submissions for Guess Number Higher or Lower.
 *   Memory Usage: 36.3 MB, less than 6.45% of Java online submissions for Guess Number Higher or Lower.
 * @author chile
 * @version 1.0
 * @date 2020/4/16 11:23
 */
public class GuessNumberHigherOrLower {


    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is lower than the guess number
     *			      1 if num is higher than the guess number
     *               otherwise return 0
     * int guess(int num);
     */
    private static class GuessGame {
        int guess(int num) {
            return Integer.compare(num, 2);
        }
    }

    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            if (n == 1) {
                return 1;
            }
            int p = n >>> 1, i = 1, j = n, t = 0;
            while (i <= j) {
                t = guess(p);
                if (t == 0) {
                    return p;
                } else if (t < 0) {
                    i = p + 1;
                } else {
                    j = p - 1;
                }
                p = (i + j) >>> 1;
            }
            return 0;
        }
    }

    @Test
    public void test1() {
        assert new Solution().guessNumber(2) == 2;
    }

}
