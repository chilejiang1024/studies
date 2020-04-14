package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2020/4/14 13:20
 */
public class FirstBadVersion {

    public class VersionControl {
        boolean isBadVersion(int version) {
            if (version < 4) {
                return false;
            }
            return true;
        }
    }

    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            if (n <= 1) {
                return 1;
            }
            if (isBadVersion(1)) {
                return 1;
            }
            long p = n / 2, i = 0, j = n;
            while (i < j) {
                if (isBadVersion((int) p)) {
                    j = p;
                } else {
                    i = p + 1;
                }
                p = (i + j) / 2;
            }
            return (int) i;
        }
    }

    @Test
    public void test1() {
        assert new Solution().firstBadVersion(5) == 4;
    }

    @Test
    public void test2() {
        assert new Solution().firstBadVersion(2126753390) == 1702766719;
    }

}
