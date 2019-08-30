package main.algorithm.leetcode;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2019/8/28 16:43
 */
public class CombinationSum {

    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();

            if (candidates.length == 0) {
                return result;
            }

            quickSort(candidates, 0, candidates.length - 1);

            findCombinations(candidates, target, result, new ArrayList<>());

            Set<String> sums = new HashSet<>();
            result = result.stream().filter(l -> {
                l.sort(Integer::compareTo);
                String combine = Arrays.toString(l.toArray());
                if (sums.contains(combine)) {
                    return false;
                } else {
                    sums.add(combine);
                    return true;
                }
            }).collect(Collectors.toCollection(ArrayList::new));

            return result;
        }

        private void findCombinations(int[] candidates, int target, List<List<Integer>> result, List<Integer> nums) {
            int sum = nums.stream().reduce(Integer::sum).orElse(0);

            if (sum == target) {
                result.add(nums);
                return;
            }

            if (sum > target) {
                return;
            }

            for (int c : candidates) {
                List<Integer> nextNums = new ArrayList<>(nums);
                nextNums.add(c);
                findCombinations(candidates, target, result, nextNums);
            }

        }

        public void quickSort(int[] nums, int head, int tail) {
            if (head >= tail) {
                return;
            }

            int l = head, r = tail, pivot = (l + r) / 2;
            while (l < r) {
                while (nums[l] < nums[pivot]) {
                    l++;
                }
                while (nums[r] >= nums[pivot]) {
                    r--;
                    if (r == l) {
                        break;
                    }
                }
                if (l < r) {
                    int t = nums[l];
                    nums[l] = nums[r];
                    nums[r] = t;
                    l++;
                    r--;
                }
            }
            quickSort(nums, head, l - 1);
            quickSort(nums, l + 1, tail);
        }
    }

    @Test
    public void test1() {
        int[] nums = { 1, 2, 4, 3, 3 };
        new Solution().quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test2() {
        int[] nums = { 2, 3, 6, 7 };
        List<List<Integer>> result = new Solution().combinationSum(nums, 7);
        result.forEach(l -> {
            l.forEach(System.out::print);
            System.out.println();
        });
    }

    @Test
    public void test3() {
        int[] nums = { 1, 2 };
        List<List<Integer>> result = new Solution().combinationSum(nums, 1);
        result.forEach(l -> {
            l.forEach(System.out::print);
            System.out.println();
        });
    }
}
