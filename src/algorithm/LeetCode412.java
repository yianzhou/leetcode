package algorithm;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/fizz-buzz/description/

public class LeetCode412 {
    public List<String> fizzBuzz(int n) {
        // write your code here
        List<String> result = new ArrayList<String>();

        int i = 1;
        while (i<=n) {
            if (i%15 == 0) { result.add("FizzBuzz"); }
            else if (i%3 == 0) { result.add("Fizz"); }
            else if (i%5 == 0) { result.add("Buzz"); }
            else { result.add(String.format("%d", i)); }
            i++;
        }

        return result;
    }
}
