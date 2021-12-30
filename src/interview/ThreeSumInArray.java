package interview;

/**
 * https://leetcode.com/problems/3sum/
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

   Notice that the solution set must NOT contain duplicate triplets.

	Example 1:
	Input: nums = [-1,0,1,2,-1,-4]
	Output: [[-1,-1,2],[-1,0,1]]
	
	Example 2:
	Input: nums = []
	Output: []
	
	Example 3:
	Input: nums = [0]
	Output: []
	 
	Constraints:
	0 <= nums.length <= 3000
	-105 <= nums[i] <= 105

 */
import java.util.ArrayList;

// https://leetcode.com/problems/3sum/

import java.util.Arrays;
import java.util.List;

public class ThreeSumInArray {
	public List<List<Integer>> getThreeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) // avoid duplicates
				continue;
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == 0) {
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;
					while (left < right && nums[left] == nums[left - 1]) // avoid duplicates
						left++;
					while (left < right && nums[right] == nums[right + 1]) // avoid duplicates
						right--;
				} else if (sum > 0) {
					right -= 1;
				} else {
					left += 1;
				}
			}
		}
		return result;

	}

	public static void main(String[] args) {
		// List<List<Integer>> result = new ThreeSumInArray().getThreeSum(new int[] {
		// -2, 1, 1, 1, 4 });
		List<List<Integer>> result = new ThreeSumInArray().getThreeSum(new int[] { -1,0,1,2,-1,-4 });
		for (List<Integer> al : result) {
			for (Integer i : al) {
				System.out.println(i);
			}
			System.out.println("");
		}

	}

}
