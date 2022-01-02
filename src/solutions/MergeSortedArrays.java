package solutions;

// https://leetcode.com/problems/merge-sorted-array/
/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

	Note:
	
	The number of elements initialized in nums1 and nums2 are m and n respectively.
	You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
	Example:
	
	Input:
	nums1 = [1,2,3,0,0,0], m = 3
	nums2 = [2,5,6],       n = 3
	
	Output: [1,2,2,3,5,6]
 *
 */
public class MergeSortedArrays {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int right = m + n - 1;
		int i1 = m - 1;
		int i2 = n - 1;
		while (i1 >= 0 && i2 >= 0) {
			if (nums1[i1] >= nums2[i2]) {
				nums1[right--] = nums1[i1];
				i1--;
			} else {
				nums1[right--] = nums2[i2];
				i2--;
			}
		}
		while (i2 >= 0) { // for the case when nums1.length = nums2.length = 1 (without including the extra 1 slot in nums1)
						  // ex: nums1 = {2, 0}, nums2 = {1}
			nums1[right--] = nums2[i2--];
		}
		for (int i = 0; i < nums1.length; i++)
			System.out.print(nums1[i]);
	}
	public static void main(String[] args) {
		new MergeSortedArrays().merge(new int[] {2,0}, 1, new int[] {1}, 1);
		
	}

}
