package algorithm;

/* https://leetcode.com/problems/search-a-2d-matrix/description/

 */

public class LeetCode74 {
    public boolean searchMatrix(int[][] M, int target) {
        //boundary
        if(M == null || M.length == 0 || M[0].length ==0) return false;

        int row = M.length;
        int col = M[0].length;
        int size = row * col;

        // matrix binary search
        int lo = 0, hi = size-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            int x = M[mid/col][mid%col];
            if(x==target){
                return true;
            }else if(x>target){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return false; // search miss
    }

    public static void main(String[] args) {
        // write your code here
        LeetCode74 solution = new LeetCode74();
        int marks[][]={{50,60,55,67,70},{62,65,70,70,81},{72,66,77,80,69}};
//        int marks[][] = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
//        int marks[][] = {{1,4},{2,5}};

        System.out.printf("%b", solution.searchMatrix(marks, 2));
    }
}
