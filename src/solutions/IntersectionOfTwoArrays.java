package solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given two integer arrays nums1 and nums2, return an array of their
 * intersection. Each element in the result must be unique and you may return
 * the result in any order.
 * 
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */

public class IntersectionOfTwoArrays {

	// O(n)
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		Set<Integer> intersect = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			if (set.contains(nums2[i])) {
				intersect.add(nums2[i]);
			}
		}
		int[] result = new int[intersect.size()];
		int i = 0;
		for (Integer num : intersect) {
			result[i++] = num;
		}
		return result;
	}

	// O(nlogn)
	public int[] intersection2(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0;
		int j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				i++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				set.add(nums1[i]);
				i++;
				j++;
			}
		}
		int[] result = new int[set.size()];
		int k = 0;
		for (Integer num : set) {
			result[k++] = num;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] result = new IntersectionOfTwoArrays()
			.intersection(new int[] { 1, 2, 2, 1 },
				new int[] { 2, 2 });
		for (int i : result) {
			System.out.println(i);
		}
		result = new IntersectionOfTwoArrays().intersection(
			new int[] { 4, 9, 5 },
			new int[] { 9, 4, 9, 8, 4 });
		for (int i : result) {
			System.out.println(i);
		}

	}

}
