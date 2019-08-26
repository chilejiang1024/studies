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

    private static List<List<Integer>> calculate(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrace(nums, result, 0, new ArrayList<>());

        return result;
    }

    private static void backtrace(int[] nums, List<List<Integer>> result, int index, List<Integer> builder) {
        if (index == nums.length) {
            result.add(builder);
        }

        for (int i = 0; i < nums.length; i++) {
            if (!builder.contains(nums[i])) {
                builder.add(nums[i]);
                backtrace(nums, result, index + 1, new ArrayList<>(builder));
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        List<List<Integer>> result = calculate(nums);
        result.forEach(l -> {
            l.forEach(System.out::print);
            System.out.println();
        });
    }

}
