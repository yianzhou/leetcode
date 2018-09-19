package algorithm;

// https://leetcode.com/problems/combinations/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode77 {

    // idea: C(n,k) = C(n-1,k-1) + C(n-1,k)
    public List<List<Integer>> combine(int n, int k) {
        if (k == 0 || k == n) {
            List<Integer> kFromk = new ArrayList<>();
            for(int i = 1; i <= k; i++) kFromk.add(i);
            List<List<Integer>> res = new ArrayList<>();
            res.add(kFromk);
            return res;
        }
        List<List<Integer>> res = this.combine(n - 1, k - 1);
        res.forEach(e -> e.add(n));
        res.addAll(this.combine(n - 1, k));
        return res;
    }

}