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
            if (!sub.isEmpty() && (null != sub.get(sum - k))) {
                count += sub.get(sum - k);
            }
            int currSumSubs = 1;
            if (!sub.isEmpty() && (null != sub.get(sum))) {
                currSumSubs += sub.get(sum);
            }
            sub.put(sum, currSumSubs); 
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1 };
        System.out.println(SubarraySum.subarraySum(nums, 2));
    }
}
