package main.algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *   <p> Runtime: 1 ms, faster than 99.42% of Java online submissions for Count and Say.
 *   <p> Memory Usage: 35.6 MB, less than 99.84% of Java online submissions for Count and Say.
 * @author chile
 * @version 1.0
 * @date 2019/4/30 10:17
 */
public class CountAndSay {

    @Test
    public void test1() {
        assert new Solution().countAndSay(1).equals("1");
    }

    @Test
    public void test2() {
        assert new Solution().countAndSay(6).equals("312211");
    }

    @Test
    public void test3() {
        assert new Solution().countAndSay(7).equals("13112221");
    }

}

class Solution {

    public static Map<Integer, String> resultMap = new HashMap<Integer, String>() {{
        put(1, "1");
        put(2, "11");
        put(3, "21");
        put(4, "1211");
        put(5, "111221");
    }};

    public String countAndSay(int n) {
        if (resultMap.containsKey(n)) {
            return resultMap.get(n);
        }

        String previousStr = countAndSay(n - 1);

        StringBuilder sb = new StringBuilder();
        int count = 0;
        char[] chars = previousStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            count = 1;
            while (true) {
                if (i + 1 < chars.length && chars[i + 1] == chars[i]) {
                    count++;
                    i++;
                } else {
                    sb.append(count);
                    sb.append(chars[i]);
                    break;
                }
            }
        }
        resultMap.put(n, sb.toString());
        return resultMap.get(n);
    }
}
