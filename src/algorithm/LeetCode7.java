package algorithm;

public class LeetCode7 {
    /*
    123 % 10 = 3;
    123 / 10 = 12;

    12 % 10 = 2;
    12 / 10 = 1;

    1 % 10 = 1;
    1 / 10 = 0;
     */

    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result *= 10;
            result += x % 10;
            x /= 10;
        }
        return (int)result == result ? (int)result : 0; // overflow boundary
    }
}
