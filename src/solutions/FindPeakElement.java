/**
 * https://leetcode.com/problems/find-peak-element/
 * 	A peak element is an element that is strictly greater than its neighbors.

	Given an integer array nums, find a peak element, and return its index. 
	If the array contains multiple peaks, return the index to any of the peaks.
	
	Input: nums = [1,2,1,3,5,6,4]
	Output: 5 or 1
 */
package solutions;

public class FindPeakElement {

	public int findPeakElement(int[] nums) {
		int left = 0;
		int right = nums.length;

		int mid = 0;
		while (left <= right) {
			mid = left / 2 + right / 2;
			if ((mid == 0 || nums[mid] > nums[mid - 1])
				&& (mid == nums.length - 1
					|| nums[mid] > nums[mid + 1])) {
				return mid;
			} else if (nums[mid - 1] > nums[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		System.out.println(new FindPeakElement()
			.findPeakElement(new int[] { 100, 20, 10, 5 }));
	}

}
