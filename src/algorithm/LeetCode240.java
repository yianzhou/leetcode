package algorithm;

// https://leetcode.com/problems/search-a-2d-matrix-ii/description/

public class LeetCode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0) return false; //boundary

        // binary search in dimension 1
        int lo = 0, hi = matrix.length-1;
        do  {
            int mid = lo+(hi-lo)/2;
            if (target<matrix[mid][0]) hi = mid-1;
            else if (target>matrix[mid][0]) lo = mid+1;
            else return true;
        } while(lo<hi-1);

        if (matrix[lo].length==0) return false; //boundary

        // binary search in dimension 2
        int i = 0, j = matrix[lo].length-1;
        while (i<=j) {
            int mid = i+(j-i)/2;
            if (target<matrix[lo][mid]) j = mid-1;
            else if (target>matrix[lo][mid]) i = mid+1;
            else return true;
        }

        return false; // search miss
    }
}
