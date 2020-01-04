package algorithm;

// https://leetcode.com/problems/poor-pigs/

public class LeetCode458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int oneCanTest = minutesToTest/minutesToDie+1;
        int testers = 0;
        while(Math.pow(oneCanTest, testers)<buckets) {
            testers++; // need more testers
        }
        return testers;
    }
}
