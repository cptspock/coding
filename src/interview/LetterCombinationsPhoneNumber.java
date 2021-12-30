package interview;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsPhoneNumber {
    public List<String> letterCombinations(String digits) {
    	LinkedList<String> result = new LinkedList<>();
    	if (digits == null || digits.isEmpty()) return result;
    	result.add(""); // initializing
    	String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    	for (int i = 0; i < digits.length(); i++) {
    		int x = Character.getNumericValue(digits.charAt(i));
    		while (result.peek().length() == i) {
    			String t = result.remove();
    			for (char s : mapping[x].toCharArray()) {
    				StringBuilder sb = new StringBuilder(t);
    				sb.append(s);
    				result.add(sb.toString());
    			}
    		}
    	}
    	return result;
    }
	public static void main(String[] args) {
		System.out.println(new LetterCombinationsPhoneNumber().letterCombinations("23"));
	}
}
