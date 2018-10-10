package algorithm;

// https://leetcode.com/problems/combination-sum/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>(); // result
        if (candidates == null || candidates.length == 0) return res; // boundary

        Arrays.sort(candidates);
        backtrack(candidates, target, 0, res, new ArrayList<>());

        return res;
    }

    private void backtrack(int[] nums, int target, int start, List<List<Integer>> res, List<Integer> sum) {
        if (target == 0) {
            res.add(new ArrayList<>(sum)); // add a new copy of sum
        }
        else if (target > 0) {
            for (int i = start; i < nums.length; i++) {
                if (nums[i] > target) {
                    return; // no need to check ahead
                }
                sum.add(nums[i]);
                backtrack(nums, target - nums[i], i, res, sum);
                sum.remove(sum.size() - 1); // remove ?
            }
        }
    }

    public static void main(String[] args) {
        LeetCode39 solution = new LeetCode39();
        int[] nums = {2, 3, 6, 7};
        solution.combinationSum(nums, 7);
    }
}
