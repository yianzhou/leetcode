package algorithm;

// https://leetcode.com/problems/combination-sum/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>(); // result
        if (candidates == null || candidates.length == 0) return res; // boundary

        Arrays.sort(candidates);
        backtrack(candidates, target, 0, res, new ArrayList<>());

        return res;
    }

    private void backtrack(int[] nums, int target, int start, List<List<Integer>> res, List<Integer> sum) {
        if (target == 0) {
            res.add(new ArrayList<>(sum)); // ⚠️ add a new copy of sum
        }
        else if (target > 0) {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) continue;
                if (nums[i] > target) return; // ⚠️ no need to check ahead
                sum.add(nums[i]);
                backtrack(nums, target - nums[i], i + 1, res, sum);
                sum.remove(sum.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode40 solution = new LeetCode40();
        int[] nums = {2, 3, 6, 7};
        solution.combinationSum2(nums, 7);
    }
}
