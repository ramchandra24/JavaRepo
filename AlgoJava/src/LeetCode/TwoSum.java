package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
 public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (mp.containsKey(target - nums[i])) {
                return new int[]{mp.get(target - nums[i]), i};
            }
            mp.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
 
 public static void main(String[] args) {
    int[] arr = {2, 7, 11, 15};
    int[] res = TwoSum.twoSum(arr, 9);
    System.out.println(res[0] + ", " + res[1]);
}
}
