package main.algorithm.backtracing;

import java.util.ArrayList;
import java.util.List;

/**
 * Title : main.algorithm.backtracing <br>
 * Company : 北京华宇元典信息服务有限公司 <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2019/8/26 18:07
 */
public class A {

    private static List<String> calculate(int[] nums) {
        List<String> result = new ArrayList<>();

        backtrace(nums, result, 0, "");

        return result;
    }

    private static void backtrace(int[] nums, List<String> result, int index, String builder) {
        if (index == nums.length) {
            result.add(builder);
            return;
        }

        for (int num : nums) {
            if (!builder.contains(String.valueOf(num))) {
                backtrace(nums, result, index + 1, builder + num);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        List<String> result = calculate(nums);
        result.forEach(System.out::println);
    }

}
