/**
 * https://leetcode.com/problems/move-zeroes/
 * 
 * Given an integer array nums, move all 0's to the end of it while 
 * maintaining the relative order of the non-zero elements.
 */
package solutions;

public class MoveZeroes {
	
	public void moveZeroes(int[] nums) {
		int n = nums.length;
		int left = 0;
		int right = 0;
		int temp;
		while (right < n) {
			if (nums[right] == 0) ++right; // move to find the first non-zero
			else if (left != right) { // left is 0, right is non-zero then swap
				temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
				++left;
				++right;
			} else { // left == right, move ahead
				++left;
				++right;
			}
		}
	
	}

	public static void main(String[] args) {
		int[] nums = new int[] {1,5,4,0,0,8,9};
		new MoveZeroes().moveZeroes(nums);
		for (int i : nums) {
			System.out.println(i);
		}
	}

}
