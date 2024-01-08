package solutions;

/**
 * Given two strings needle and haystack, return the index of the first
 * occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1: Input: haystack = "sadbutsad", needle = "sad" Output: 0
 * Explanation: "sad" occurs at index 0 and 6. The first occurrence is at index
 * 0, so we return 0.
 * 
 * Example 2: Input: haystack = "leetcode", needle = "leeto" Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 * 
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 */
public class FindIndexOfFirstOccurrenceInString {

	// O(2*n) = O(n)
	public int strStr(String haystack, String needle) {

		// build LPS - longest prefix suffix
		int lps[] = new int[needle.length()];
		int prevLPS = 0, i = 1;
		while (i < needle.length()) {
			if (needle.charAt(i) == needle.charAt(prevLPS)) {
				lps[i] = prevLPS + 1;
				prevLPS += 1;
				i += 1;
			} else if (prevLPS == 0) {
				lps[i] = 0;
				i += 1;
			} else {
				prevLPS = lps[prevLPS - 1];
			}
		}

		i = 0;
		int j = 0;

		// KMP algo
		while (i < haystack.length()) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				i += 1;
				j += 1;
			} else if (j == 0)
				i += 1;
			else
				j = lps[j - 1];
			if (j == needle.length())
				return i - needle.length();

		}
		return -1;

	}

	public static void main(String[] args) {
		System.out.println(new FindIndexOfFirstOccurrenceInString()
			.strStr("sadbutsad", "sad"));
		System.out.println(new FindIndexOfFirstOccurrenceInString()
			.strStr("leetcode", "leeto"));
		System.out.println(new FindIndexOfFirstOccurrenceInString()
			.strStr("AAAXAAAAA", "AAAA"));
	}

}
