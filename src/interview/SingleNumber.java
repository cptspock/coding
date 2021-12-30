/**
 * Given a non-empty array of integers nums, 
 * every element appears twice except for one. 
 * Find that single one.
   
   Clarification: You must implement a solution with a linear runtime complexity and use only constant extra space.
 */

package interview;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
	public int findSingleNumber(int[] nums) { // solution with extra space for map - O(n) 
		Map<Integer, Integer> freq = new HashMap<>();
		for (int num : nums) {
			freq.put(num, freq.getOrDefault(num, 0)+1);
		}
		for (int key : freq.keySet()) {
			if (freq.get(key) == 1) 
				return key;
		}
		return -1;
	}
	
	public int findSingleNumber2(int[] nums) { // solution with no extra space O(1)
		int result = 0;
		for (int num : nums) {
			result ^= num; // if a number is XOR with itself it returns 0. So when you XOR with all nums, the remainder will be
						   // the number which has only 1 occurence.
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(new SingleNumber().findSingleNumber2(new int[]{ 1, 1, 3, 2, 3 }));
	}
	
	

}
