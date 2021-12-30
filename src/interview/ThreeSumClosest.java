package interview;

// https://leetcode.com/problems/3sum-closest/
import java.util.Arrays;

public class ThreeSumClosest {
	public int getNearestSum(int[] nums, int target) {
		Arrays.sort(nums);
		int diff = Integer.MAX_VALUE;
		int runningSum = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				runningSum = nums[i] + nums[left] + nums[right];
				if (runningSum - target < diff) {
					left++;
					diff = runningSum - target;
				}
				else if (runningSum - target > diff) {
					right--;
				}
				else return runningSum;
			}
		}
		return runningSum;
	}
	public static void main(String[] args) {
		System.out.print(new ThreeSumClosest().getNearestSum(new int[]{-1,2,1,-4}, 1));
	}

}
