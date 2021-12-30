package interview;

// https://leetcode.com/problems/palindrome-number/
public class PalindromeInteger {
	public boolean isPalindrome(int x) {
		if (x % 10 == 0 && x!= 0) return false; // this is needed for input like 10,20,30...
	    int reversedNumber = 0;
	    while (x > reversedNumber) { // this will take care of -ve ints, no special logic required
	        reversedNumber = reversedNumber * 10 + x % 10;
	        x = x/10;
	    }
	    return x == reversedNumber || x == reversedNumber/10;
	}
	public static void main(String[] args) {
		System.out.print(new PalindromeInteger().isPalindrome(10));
	}

}
