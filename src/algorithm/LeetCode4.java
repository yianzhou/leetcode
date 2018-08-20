package algorithm;

// https://leetcode.com/problems/median-of-two-sorted-arrays/description/

public class LeetCode4 {
    public double findMedianSortedArrays(int[] A, int[] B) {
        // always process at the shorter first
        int a = A.length;
        int b = B.length;
        if (a>b) return findMedianSortedArrays(B, A);

        // boundary
        if (a==0) return median(B);

        if ( (a + b) % 2 == 1 ) { //odd
            int lo = 0, hi = a;
            while(lo<=hi) {
                // partition
                int i =  lo+(hi-lo)/2;
                int j = (a+b-2*i-1)/2;

                if (i>0 && A[i-1]>B[j]) hi = i-1;
                else if (i==a) return B[j];
                else if (j>0 && A[i]<B[j-1]) lo = i+1;
                else if (i==0) {
                    if (j==b) return A[0];
                    else return Math.min(A[0], B[j]);
                }
                else {
                    return Math.min(A[i], B[j]);
                }
            }
        }
        else { //even
            int lo = 0, hi = a;
            while(lo<=hi) {
                // partition
                int i =  lo+(hi-lo)/2;
                int j = (a+b-2*i)/2;

                if (i>0 && A[i-1]>B[j]) hi = i-1;
                else if (i==a){
                    if (j==0) return (A[a-1]+B[0])/2.0;
                    else return (Math.max(A[a-1], B[j-1])+B[j])/2.0;
                }
                else if (j>0 && A[i]<B[j-1]) lo = i+1;
                else if (i==0) {
                    if (j==b) return (B[j-1]+A[0])/2.0;
                    else return (B[j-1]+Math.min(A[0], B[j]))/2.0;
                }
                else {
                    return (Math.max(A[i-1], B[j-1]) + Math.min(A[i], B[j]))/2.0;
                }
            }
        }

        return -1;
    }

    // get the median in int array
    public double median(int[] A) {
        if (A==null) { return -1; }
        int a = A.length;
        if (a==0) { return -1;}

        if ( a % 2 == 1 ) {
            return A[a/2];
        }
        else {
            return (A[a/2-1]+A[a/2])/2.0;
        }
    }

    public static void main(String[] args) {
        LeetCode4 solution = new LeetCode4();
//        int[] A = new int[] {1,2};
//        int[] B = new int[] {3,4};

        int[] A = new int[] {1};
        int[] B = new int[] {2,3,4};

        System.out.printf("%f", solution.findMedianSortedArrays(A, B));
    }
}
