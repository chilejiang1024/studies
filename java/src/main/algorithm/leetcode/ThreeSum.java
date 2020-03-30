package main.algorithm.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2019/6/21 14:29
 */
public class ThreeSum {

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();

            if (nums.length < 3) {
                return result;
            }

            quickSort(nums, 0, nums.length - 1);

            Set<Integer> calCache = new HashSet<>(4096);
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                int[] tempNums = new int[nums.length - 1];
                for (int j = 0; j < tempNums.length; j++) {
                    if (j >= i) {
                        tempNums[j] = nums[j + 1];
                    } else {
                        tempNums[j] = nums[j];
                    }
                }
                if (calCache.contains(-num)) {

                } else {
                    List<List<Integer>> two = findTwo(tempNums, -num);
                    two.forEach(l -> {
                        l.add(num);
                        result.add(l);
                    });
                    calCache.add(-num);
                }
            }

            return removeDuplication(result);
        }

        public List<List<Integer>> removeDuplication(List<List<Integer>> result) {
            Set<Integer> calculatedSet = new HashSet<>();
            Iterator<List<Integer>> iterator = result.iterator();
            while (iterator.hasNext()) {
                List<Integer> l = iterator.next();
                l.sort(Integer::compareTo);
                int calculatedSum = String.format("%d%d%d", l.get(0), l.get(1), l.get(2)).hashCode();
                if (calculatedSet.contains(calculatedSum)) {
                    iterator.remove();
                } else {
                    calculatedSet.add(calculatedSum);
                }
            }
            return result;
        }

        public List<List<Integer>> findTwo(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();

            int t = 0;
            for (int i = 0, j = nums.length - 1; i <= j; ) {
                t = nums[i] + nums[j];
                if (t > target) {
                    j--;
                    continue;
                }
                if (t < target) {
                    i++;
                    continue;
                }
                if (t == target) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    result.add(l);
                    i++;
                    j--;
                }
            }

            return result;
        }

        public void quickSort(int[] nums, int h, int t) {
            if (h >= t) {
                return;
            }

            int pivot = nums[t], i = h, j = t - 1, temp = 0;
            while (i < j) {
                if (nums[i] >= pivot) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    j--;
                } else {
                    i++;
                }
            }

            if (i > 0 && nums[i] >= pivot) {
                i--;
                j = i;
            }

            for (int k = t; k > j;) {
                if (nums[j] > pivot) {
                    temp = nums[k];
                    nums[k] = nums[j];
                    nums[j] = temp;
                    k--;
                } else {
                    j++;
                }
            }



            quickSort(nums, h, i);
            quickSort(nums, j, t);
        }


    }

    @Test
    public void test1() {
//        int[] array = { -7, -7, 14, -13,5,13};
         int[] array = { -13,5,13,12,-2,-11,-1,12,-3,0,-3,-7,-7,-5,-3,-15,-2,14,14,13,6,-11,-11,5,-15,-14,5,-5,-2,0,3,-8,-10,-7,11,-5,-10,-5,-7,-6,2,5,3,2,7,7,3,-10,-2,2,-12,-11,-1,14,10,-9,-15,-8,-7,-9,7,3,-2,5,11,-13,-15,8,-3,-7,-12,7,5,-2,-6,-3,-10,4,2,-5,14,-3,-1,-10,-3,-14,-4,-3,-7,-4,3,8,14,9,-2,10,11,-10,-4,-15,-9,-1,-1,3,4,1,8,1 };
        new Solution().quickSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
        System.out.println();

        List<List<Integer>> result = new Solution().findTwo(array, 9);
        result.forEach(l -> l.forEach(System.out::println));
        System.out.println();

        result = new Solution().threeSum(array);
        result.forEach(l -> {
            l.forEach(System.out::print);
            System.out.println();
        });
    }


}
