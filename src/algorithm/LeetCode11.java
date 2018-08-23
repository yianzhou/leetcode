package algorithm;

// https://leetcode.com/problems/container-with-most-water/description/

public class LeetCode11 {

    /*
    idea:
    1. 水缸不能倾斜，因此总是受到较小的纵坐标制约
    2. 两个指针分别从首尾相向移动，当左指针指向的数大于右指针，则移动右指针；反之，移动左指针。
     */

    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) return 0;

        int lo = 0;
        int hi = height.length - 1;

        int max = 0;

        while (lo < hi) {
            int newMax = 0;
            if (height[lo] > height[hi]) {
                newMax = height[hi] * (hi - lo);
                hi--;
            }
            else {
                newMax = height[lo] * (hi - lo);
                lo++;
            }
            max = Math.max(max, newMax);
        }
        return max;
    }
}
