package solutions;

// https://leetcode.com/problems/longest-common-prefix/
//https://www.youtube.com/watch?v=1YQmI7F9dJ0

public class LongestCommonPrefix {
	public String getLongestCommonPrefix(String[] strs) {
		String longestCommonPrefix = "";
		if (strs == null || strs.length == 0) {
			return longestCommonPrefix;
		}
		int index = 0;
		for (char c : strs[0].toCharArray()) {
			for (int i = 1; i < strs.length; i++) {
				if (index >= strs[i].length() || c != strs[i].charAt(index)) {
					return longestCommonPrefix;
				}
			}
			longestCommonPrefix += c;
			index++;
		}
		return longestCommonPrefix;
	}
	public static void main(String[] args) {
		System.out.println(new LongestCommonPrefix().getLongestCommonPrefix(new String[]{"flower", "flow", "flight"}));
	}

}
