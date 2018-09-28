package algorithm;

// https://leetcode.com/problems/combinations/description/

import java.util.ArrayList;
import java.util.List;

public class LeetCode77 {

    // idea: C(n,k) = C(n-1,k-1) + C(n-1,k)
    // Pascal's identity
    public List<List<Integer>> combine(int n, int k) {
        if (k == 0 || k == n) {
            List<Integer> kFromk = new ArrayList<>(); // choose k elements from k elements
            for(int i = 1; i <= k; i++) kFromk.add(i); // means choose all elements
            List<List<Integer>> res = new ArrayList<>();
            res.add(kFromk);
            return res;
        }
        // C(n-1,k-1)
        List<List<Integer>> res = this.combine(n - 1, k - 1);
        res.forEach(e -> e.add(n));
        // C(n-1,k)
        res.addAll(this.combine(n - 1, k));
        return res;
    }
}