package solutions;

public class LongestPalindromeSubstring2 {

	public static String longestPalindromeSubstring(String s) {
		int n = s.length();
		boolean[] dp = new boolean[n];
		int maxLength = 0;
		int start = 0;

		// Single character substrings are palindromes
		for (int i = 0; i < n; i++) {
			dp[i] = true;
		}

		// Check for palindromic substrings of length 2
		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i] = true;
				start = i;
				maxLength = 2;
			} else {
				dp[i] = false;
			}
		}

		// Check for palindromic substrings of length greater than 2
		for (int len = 3; len <= n; len++) {
			boolean prev = true;
			for (int i = 0; i < n - len + 1; i++) {
				int j = i + len - 1;
				boolean temp = dp[i];
				if (s.charAt(i) == s.charAt(j) && prev) {
					dp[i] = true;
					if (len > maxLength) {
						maxLength = len;
						start = i;
					}
				} else {
					dp[i] = false;
				}
				prev = temp;
			}
			if (maxLength == len - 1) {
				// We have found the longest palindrome substring
				break;
			}
		}

		return s.substring(start, start + maxLength);
	}

	public static void main(String[] args) {
		String s = "aaaabbaa";
		String longestPalindrome = longestPalindromeSubstring(s);
		System.out.println("Longest Palindrome Substring of " + s + " is: "
			+ longestPalindrome);
	}

}
