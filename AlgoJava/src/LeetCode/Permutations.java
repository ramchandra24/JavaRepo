package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cper = new ArrayList<Integer>();
        for (int i : nums) {
            cper.add(i);
        }
        permuteUtil(nums, res, cper, 0);
        return res;
    }

    private void permuteUtil(int[] nums, List<List<Integer>> res, List<Integer> cper, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(cper));
            return;
        }
        for (int i = index; i < nums.length; ++i) {
            Collections.swap(cper, index, i);
            permuteUtil(nums, res, cper, index + 1);
            Collections.swap(cper, index, i);
        }
    }

    public static void main(String[] args) {
        Permutations per = new Permutations();
        List<List<Integer>> res = per.permute(new int[] { 1, 2, 3, 4, 5 });
        for (List<Integer> l : res) {
            System.out.println(l);
        }
    }
}
