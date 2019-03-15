package main.algorithm.quicksort;

/**
 * Title : main.algorithm.quicksort <br>
 * Description :
 *  <p>
 *  <ul> 
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/4/10 11:11
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {2, 6, 13, 7, 12, 3};
        out(nums);
        quickSort(nums, 0, nums.length - 1);
        out(nums);
    }

    private static void out(int[] nums) {
        for (int num : nums) {
            System.out.print(num);
            System.out.print(" ");
        }
        System.out.println();
    }

    private static void quickSort(int[] nums, int head, int tail) {
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
        quickSort(nums, i + 1 , tail);
    }

}
