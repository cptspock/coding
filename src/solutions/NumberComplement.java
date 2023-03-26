package solutions;

/**
 * https://leetcode.com/problems/number-complement/
 * 
 * The complement of an integer is the integer you get when you flip all the 0's
 * to 1's and all the 1's to 0's in its binary representation.
 * 
 * For example, The integer 5 is "101" in binary and its complement is "010"
 * which is the integer 2.
 * 
 * Given an integer num, return its complement.
 *
 */

public class NumberComplement {

	public int findComplement(int num) {
		if (num == 0)
			return 1;
		int temp = num;
		int bit = 1;
		while (temp != 0) {
			num = num ^ bit;
			bit = bit << 1;
			temp = temp >> 1;
		}
		return num;

	}

	public static void main(String[] args) {
		System.out.println(
			new NumberComplement().findComplement(5));

	}

}
