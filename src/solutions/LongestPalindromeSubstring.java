package solutions;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 
 *
 */
public class LongestPalindromeSubstring {

	public static String longestPalindromeSubstring(String s) {
		int n = s.length();
		if (n == 0 || n == 1)
			return s;
		boolean[][] dp = new boolean[n][n];
		int maxLength = 1;
		int start = 0;

		// Single character substrings are palindromes
		for (int i = 0; i < n; i++) {
			dp[i][i] = true;
		}

		// Check for palindromic substrings of length 2
		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = true;
				start = i;
				maxLength = 2;
			}
		}

		// Check for palindromic substrings of length greater than 2
		for (int len = 3; len <= n; len++) {
			for (int i = 0; i < n - len + 1; i++) {
				int j = i + len - 1;
				if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
					dp[i][j] = true;
					if (len > maxLength) {
						maxLength = len;
						start = i;
					}
				}
			}
		}

		return s.substring(start, start + maxLength);
	}

	public static void main(String[] args) {
		String s = "aabbigibbpiwa";
		String longestPalindrome = longestPalindromeSubstring(s);
		System.out.println("Longest Palindrome Substring of " + s + " is: "
			+ longestPalindrome);
	}
}
