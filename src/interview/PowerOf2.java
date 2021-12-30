/**
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 * https://leetcode.com/problems/power-of-two/
 */

package interview;

public class PowerOf2 {
	public boolean isPowerOf2(int n) {
		int power = 0;
		if (n == 0) return false; // in case we need to support input of 0
		while (Math.abs(n) != 1) { // in case we need to support power of (-2)
			if (n % 2 == 1) return false;
			n = n / 2;
			power++;
		}
		System.out.println(power);
		return true;
	}
	
	public boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }
	
	public static void main(String[] args) {
		System.out.println(new PowerOf2().isPowerOf2(-32));
		System.out.println(new PowerOf2().isPowerOfTwo(-32));
		
	}

}
