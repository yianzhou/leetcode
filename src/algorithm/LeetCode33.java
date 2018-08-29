package algorithm;

import java.util.Stack;

// https://leetcode.com/problems/search-in-rotated-sorted-array/description/

public class LeetCode33 {

    // 0, 1, 2, 3, 4
    // 4, 0, 1, 2, 3
    // 3, 4, 0, 1, 2
    // 2, 3, 4, 0, 1
    // 1, 2, 3, 4, 0

    // if we can find the smallest number 0, its subscript 2 is the value of rotate

    public int search(int[] nums, int target) {
        int rotate = numOfRotate(nums);

        // binary search
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int midR = mid + rotate; // The "real" mid value after rotate
            if (midR >= nums.length) midR -= nums.length;
            if (nums[midR] == target) return midR;
            else if (nums[midR] > target) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    private int numOfRotate(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    public static void main(String args[]) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {4, 5, 1, 2, 3};

        LeetCode33 solution = new LeetCode33();
        System.out.println(solution.numOfRotate(nums2));
    }
}
