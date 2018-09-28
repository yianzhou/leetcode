package algorithm;

// https://leetcode.com/problems/next-permutation/

public class LeetCode31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) return; // boundary

        // first, find a(j) < a(j+1)
        int j = nums.length - 2;
        while(j > 0 && nums[j] >= nums[j+1]) {
            j--;
        }
        // now, {j is the largest subscript with aj < aj+1}

        int k = nums.length - 1;
        while(k > j && nums[j] >= nums[k]) {
            k--;
        }
        // now, {ak is the smallest integer greater than aj to the right of aj }

        // interchange aj and ak
        interchange(nums, j, k);

        // {this puts the tail end of the permutation after the jth position in increasing order}
        int r = nums.length - 1;
        int s = j + 1;
        if (k == 0) s = k; // in case of the largest permutation such as {3, 2, 1}
        while (r > s) {
            interchange(nums, r, s);
            r--;
            s++;
        }
    }

    private void interchange(int[] A, int a, int b) {
        int ex = A[b];
        A[b] = A[a];
        A[a] = ex;
    }

    public static void main(String[] args) {
        LeetCode31 solution = new LeetCode31();
        int nums[] = {2, 3, 1};
        solution.nextPermutation(nums);
    }
}
