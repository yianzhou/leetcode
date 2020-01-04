package algorithm;

public class Main {
    public static void main(String[] args) {
	// write your code here
        LeetCode1 code = new LeetCode1();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = code.twoSum(nums, target);
        for (int element: res) {
            System.out.println(element);
         }
    }
}
