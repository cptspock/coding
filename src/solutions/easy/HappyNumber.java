package solutions.easy;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/happy-number/description/
 * 
 * Write an algorithm to determine if a number n is happy.
 * 
 * A happy number is a number defined by the following process:
 * 
 * Starting with any positive integer, replace the number by the sum of the
 * squares of its digits. Repeat the process until the number equals 1 (where it
 * will stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy. Return true if n is a
 * happy number, and false if not.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 19 Output: true<br>
 * Explanation: <br>
 * 1*1 + 9*9 = 82 <br>
 * 8*8 + 2*2 = 68 <br>
 * 6*6 + 8*8 = 100 <br>
 * 1*1 + 0*0 + 0*0 = 1<br>
 * 
 * 
 * Example 2:
 * 
 * Input: n = 2 Output: false
 *
 * 
 */
public class HappyNumber {

	public boolean isHappy(int n) {
		HashSet<Integer> seen = new HashSet<>();
		while (n != 1) {
			int current = n;
			int sum = 0;
			while (current != 0) {
				sum += (current % 10) * (current % 10);
				current /= 10;
			}

			if (seen.contains(sum))
				return false;
			seen.add(sum);
			n = sum;
		}
		return true;

	}

	public static void main(String[] args) {
		System.out.println(new HappyNumber().isHappy(2));
		System.out.println(new HappyNumber().isHappy(19));
		System.out.println(new HappyNumber().isHappy(91));

	}

}
