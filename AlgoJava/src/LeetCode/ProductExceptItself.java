package LeetCode;

import java.util.Arrays;

public class ProductExceptItself {
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        if (nums.length < 2) {
            return res;
        }
        left[0] = 1;
        right[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; ++i) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; --i) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        printarr(left);
        printarr(right);
        for (int i = 0; i < nums.length; ++i) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

    public static void printarr(int[] nums) {
        for (int a : nums) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int[] res = ProductExceptItself.productExceptSelf(nums);
        ProductExceptItself.printarr(nums);
        ProductExceptItself.printarr(res);

    }
}
