package main.algorithm.leetcode;

import jdk.internal.dynalink.linker.LinkerServices;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.time.temporal.Temporal;
import java.util.*;

/**
 * Title : main.algorithm.leetcode <br>
 * Company : 北京华宇元典信息服务有限公司 <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2019/3/14 17:29
 */
public class TwoSum {

    static class Solution {

        static boolean done(int num, int[] tempNums, int target) {
            int t = target - num;

            return true;
        }

        static int[] twoSum(int[] nums, int target) {
            int[] answer = new int[2];
            int[] temp = nums.clone();
            for (int i = 0; i < nums.length; i++) {

                for (int j = 0; j < i; j++) {
                    if (nums[i] + temp[j] == target) {
                        answer[0] = j;
                        answer[1] = i;
                        return answer;
                    }
                }
            }

            return answer;
        }

        static int[] twoSum2(int[] nums, int target) {
            List<Integer> l = new ArrayList<>();
            for (int num : nums) {
                l.add(num);
            }

            quickSort(nums, 0, nums.length - 1);

            int i = 0, j = nums.length - 1;

            while (i < j) {
                if (nums[i] + nums[j] > target) {
                    j--;
                } else if (nums[i] + nums[j] < target) {
                    i++;
                } else {
                    if (nums[i] == nums[j]) {
                        return new int[] { l.indexOf(nums[i]), l.lastIndexOf(nums[j]) };
                    } else {
                        return new int[] { l.indexOf(nums[i]), l.indexOf(nums[j]) };
                    }
                }
            }

            return new int[2];
        }

        static void quickSort(int[] nums, int head, int tail) {
            if (nums == null || nums.length <= 1 || head >= tail) {
                return;
            }

            int i = head, j = tail, pivot = nums[(i + j) / 2];
            while (i < j) {
                while (nums[i] < pivot) {
                    i++;
                }
                while (nums[j] > pivot) {
                    j--;
                }
                if (i < j) {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                    i++;
                    j--;
                }
            }
            quickSort(nums, head, i - 1);
            quickSort(nums, i + 1, tail);
        }

    }

    public static void main(String[] args) {
        int[] array = { 2, 7, 11, 15 };
        for (int i : Solution.twoSum2(array, 9)) {
            System.out.println(i);
        }
    }

}
