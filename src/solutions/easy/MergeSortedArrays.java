package solutions.easy;

// https://leetcode.com/problems/merge-sorted-array/
/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * Note:
 * 
 * The number of elements initialized in nums1 and nums2 are m and n
 * respectively. You may assume that nums1 has enough space (size that is equal
 * to m + n) to hold additional elements from nums2. Example:
 * 
 * Input: nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6], n = 3
 * 
 * Output: [1,2,2,3,5,6]
 *
 */
public class MergeSortedArrays {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int right = m + n - 1;
		int i = m - 1;
		int j = n - 1;
		while (j >= 0) {
			if (i >= 0 && nums1[i] >= nums2[j]) {
				nums1[right--] = nums1[i];
				i--;
			} else {
				nums1[right--] = nums2[j];
				j--;
			}
		}

		for (int k = 0; k < nums1.length; k++)
			System.out.print(nums1[k] + " ");
		System.out.println("\n");
	}

	public static void main(String[] args) {

		new MergeSortedArrays().merge(new int[] { 2, 0 }, 1, new int[] { 1 },
			1);

		new MergeSortedArrays().merge(new int[] { 1, 2, 3, 0, 0, 0 }, 3,
			new int[] { 2, 5, 6 }, 3);

		new MergeSortedArrays().merge(new int[] { 0 }, 0, new int[] { 1 }, 1);

	}

}
