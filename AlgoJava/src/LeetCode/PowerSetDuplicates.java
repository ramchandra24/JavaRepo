package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PowerSetDuplicates {

    public List<List<Integer>> subsets(int[] nums) {
        // List<List<Integer>> results = new ArrayList<>();
        Set<List<Integer>> results = new HashSet<>();
        Arrays.sort(nums);
        subsetUtil(results, new LinkedList<>(), nums, 0);

        List<List<Integer>> res = new ArrayList<>(results);
        return res;
    }

    private void subsetUtil(Set<List<Integer>> results, LinkedList<Integer> sub, int[] nums, int start) {
        Collections.sort(sub);
        results.add(new ArrayList<>(sub));
        for (int i = start; i < nums.length; ++i) {
            sub.addLast(nums[i]);
            subsetUtil(results, sub, nums, i + 1);
            sub.removeLast();
        }
    }

    public static void main(String[] args) {
        PowerSetDuplicates p = new PowerSetDuplicates();
        List<List<Integer>> results = p.subsets(new int[] { 1, 2, 3, 4, 5, 6 });
        for (List<Integer> li : results) {
            System.out.println(li);
        }
    }

}
