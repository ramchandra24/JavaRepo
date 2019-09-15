package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> sub = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (sum == k) {
                ++count;
            }
            count += sub.get(sum - k) == null ? 0 : sub.get(sum - k);
            sub.put(sum, sub.get(sum) == null ? 1 : sub.get(sum) + 1); 
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1 };
        System.out.println(SubarraySum.subarraySum(nums, 2));
    }
}
