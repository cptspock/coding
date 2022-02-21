package solutions;

import java.util.HashSet;

/**
 * Given an array nums containing n distinct numbers in the range [0, n], return
 * the only number in the range that is missing from the array.
 *
 * https://leetcode.com/problems/missing-number/
 * 
 */
public class MissingNumber {

	// O(n) space
	public int missingNumber(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		for (int i = 0; i <= nums.length; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}
		return -1;
	}

	// O(1) space
	public int missingNumber2(int[] nums) {
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		int n = nums.length + 1;
		return (n * (n - 1) / 2) - sum;
	}

	public static void main(String[] args) {
		System.out.println(new MissingNumber()
			.missingNumber2(new int[] { 3, 0, 1 }));

	}

}
