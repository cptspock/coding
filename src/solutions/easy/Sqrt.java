package solutions.easy;

/**
 * 
 * Given a non-negative integer x, return the square root of x rounded down to
 * the nearest integer. The returned integer should be non-negative as well.
 * 
 * You must not use any built-in exponent function or operator.
 * https://leetcode.com/problems/sqrtx/description/
 * 
 * Example 1:
 * 
 * Input: x = 4 Output: 2 Explanation: The square root of 4 is 2, so we return
 * 2.
 * 
 * Example 2:
 * 
 * Input: x = 8 Output: 2 Explanation: The square root of 8 is 2.82842..., and
 * since we round it down to the nearest integer, 2 is returned.
 *
 */
public class Sqrt {

	public int mySqrt(int x) {
		if (x == -1)
			return -1;
		long left = 0; // note we use long values to prevent overflow
		long right = x;
		long sqrt = 0;
		long mid = 0;

		while (left <= right) {
			mid = left + (right - left) / 2; // prevent overflow
			if (mid * mid > x)
				right = mid - 1;
			else if (mid * mid < x) {
				left = mid + 1;
				sqrt = mid; // it could be the needed value so we store it
			} else
				return (int) mid;
		}
		return (int) sqrt;
	}

	public static void main(String[] args) {
		System.out.println(new Sqrt().mySqrt(2147483647));
		System.out.println(new Sqrt().mySqrt(8));
		System.out.println(new Sqrt().mySqrt(0));

	}
}
