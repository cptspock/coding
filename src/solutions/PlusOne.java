/**
 * https://leetcode.com/problems/plus-one/
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.
 */
package solutions;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int len = digits.length;
		for (int i = len - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		int[] newNumber = new int[len + 1];
		newNumber[0] = 1;
		return newNumber;
	}

	public static void main(String[] args) {
		int[] res = new PlusOne().plusOne(new int[] { 9, 9, 9 });
		for (int num : res) {
			System.out.println(num);
		}
	}

}
