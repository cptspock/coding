/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 * https://leetcode.com/problems/valid-anagram/
 * 
 */
package solutions;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
    	if (s.length() != t.length()) {
    		return false;
    	}
    	
    	Map<Character, Integer> counts = new HashMap<>();
    	for (char c : s.toCharArray()) {
    		counts.put(c, counts.getOrDefault(c, 0) + 1);
    	}
    	
    	for (char c : t.toCharArray()) {
    		counts.put(c, counts.getOrDefault(c, 0) - 1);
    		if (counts.get(c) < 0) {
    			return false;
    		}
    	}
    	return true;
    }
	public static void main(String[] args) {
		System.out.println(new ValidAnagram().isAnagram("cinemA", "iceman"));
	}

}
