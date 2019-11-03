package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> results = new HashSet<>();
        Arrays.sort(candidates);
        combSumUtil(results, new LinkedList<>(), candidates, 0, target);
        List<List<Integer>> res = new ArrayList<>(results);
        return res;
    }

    private void combSumUtil(Set<List<Integer>> results, LinkedList<Integer> csum, int[] nums, int start, int remain) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            Collections.sort(csum);
            results.add(new ArrayList<>(csum));
        } else {
            for (int i = start; i < nums.length; ++i) {
                csum.addLast(nums[i]);
                combSumUtil(results, csum, nums, i, remain - nums[i]);
                csum.removeLast();
            }
        }

    }

    public static void main(String[] args) {
        CombinationSum c = new CombinationSum();
        List<List<Integer>> res = c.combinationSum(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, 10);
        for (List<Integer> li : res) {
            System.out.println(li);
        }
    }
}
