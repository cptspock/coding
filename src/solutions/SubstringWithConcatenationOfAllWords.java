package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * 
 * 	Example 1:
		Input: s = "barfoothefoobarman", words = ["foo","bar"]
		Output: [0,9]
		Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
		The output order does not matter, returning [9,0] is fine too.

	Example 2:
		Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
		Output: []
	
	Example 3:
		Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
		Output: [6,9,12]
 *
 */
public class SubstringWithConcatenationOfAllWords {
	public static List<Integer> substringUsingConcatenationOfAllGivenWords(String str, String[] words) {
	    if (str == null || str.length() == 0 || words == null || words.length == 0) {
	      return new ArrayList<>();
	    }
	    
	    Map<String, Integer> frequencyMap = new HashMap<>(); // {foo = 1, bar = 1}
	    for(String word: words) {
	      frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
	    }
	    
	    int eachWordLength = words[0].length();
	    int totalWordCount = words.length;
	    List<Integer> result = new ArrayList<>();
	    
	    for (int i = 0; i <= str.length() - totalWordCount * eachWordLength; i++) {
	      Map<String, Integer> seenWords = new HashMap<>(); // store words which are seen and their count so far
	      for (int j = 0; j < totalWordCount; j++) {
	        int wordIndex = i + j * eachWordLength;
	        String word = str.substring(wordIndex, wordIndex + eachWordLength);
	        if (!frequencyMap.containsKey(word)) {
	          break;
	        }
	        seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);
	        if (seenWords.get(word) > frequencyMap.get(word)) {
	          break;
	        }
	        if (j + 1 == totalWordCount)   { // j + 1 since j starts from 0
	          result.add(i); 
	        }
	      }
	    }
	    
	    return result;
	  }
	public static void main(String[] args) {
		System.out.println(SubstringWithConcatenationOfAllWords.substringUsingConcatenationOfAllGivenWords("barfoofoobarthefoobarman", new String[] {"bar","foo","the"}));
	}

}
