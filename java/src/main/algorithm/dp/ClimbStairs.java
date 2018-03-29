package main.algorithm.dp;

import java.util.HashMap;
import java.util.Objects;

/**
 * Title : main.algorithm.dp
 * Company : 北京华宇元典信息服务有限公司
 * Description :
 *  <p> 找出爬上n阶台阶, 一共有多少种上法 (一次只能上一个或者两个台阶)
 *  <p> 动态规划
 *
 * @author chile
 * @version 1.0
 * @date 2017/6/19 16:45
 */
public class ClimbStairs {

    public static void main(String[] args) {
        int numOfStairs = 10;
        System.out.println(getWaysToClimbStairs(numOfStairs));
    }

    private static int getWaysToClimbStairs(int n) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            int temp = getWaysToClimbStairs(n - 1) + getWaysToClimbStairs(n - 2);
            cache.put(n, temp);
            return temp;
        }
    }



}
