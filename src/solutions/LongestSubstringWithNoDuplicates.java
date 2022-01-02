package solutions;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithNoDuplicates {

	public String lengthOfLongestSubstring(String str) {
		Map<Character, Integer> lastSeen = new HashMap<>(); // maps each character with its index in str
		int[] longest = { 0, 1 }; // stores the indexes of the longest substring. 
		int startIdx = 0;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (lastSeen.containsKey(c)) {
				startIdx = Math.max(startIdx, lastSeen.get(c) + 1); // add 1 so the substring can start from the
																	// character after the duplicate char
			}
			if (longest[1] - longest[0] < i + 1 - startIdx) {
				longest[0] = startIdx; 
				longest[1] = i + 1; // +1 because when we use str.substring(x,y) that does not include the char in index 'y'
				//longest = new int[] { startIdx, i + 1 }; 
			}
			lastSeen.put(c, i);
		}
		String result = str.substring(longest[0], longest[1]);
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new LongestSubstringWithNoDuplicates().lengthOfLongestSubstring("pwwkep")); //clementisacap
	}

}
