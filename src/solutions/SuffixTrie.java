/**
 * https://www.algoexpert.io/questions/Suffix%20Trie%20Construction
 */
package solutions;

import java.util.HashMap;
import java.util.Map;

public class SuffixTrie {
	static class TrieNode {
		Map<Character, TrieNode> children = new HashMap<>();
	}
	
	TrieNode root = new TrieNode();
	char endSymbol = '*';

	public SuffixTrie(String str) {
		populateSuffixTrie(str);
	}
	
	public void populateSuffixTrie(String str) {
		for (int i = 0; i < str.length(); i++) {
			insertSubstringStartingAt(i, str);
		}
	}

	private void insertSubstringStartingAt(int i, String str) {
		TrieNode curr = root;
		for (int j = i; j < str.length(); j++) {
			char letter = str.charAt(j);
			if (!curr.children.containsKey(letter)) {
				curr.children.put(letter, new TrieNode());
			}
			curr = curr.children.get(letter);
		}
		curr.children.put(endSymbol, null);
	}
	
	public boolean contains(String str) {
		TrieNode lastCharNode = containsHelper(str);
		return lastCharNode.children.containsKey(endSymbol);
	}

	private TrieNode containsHelper(String str) {
		TrieNode curr = root;
		for (char letter : str.toCharArray()) {
			if (!curr.children.containsKey(letter)) {
				return null;
			}
			curr = curr.children.get(letter);
		}
		return curr;
	}
	

	public static void main(String[] args) {
		SuffixTrie sufTrie = new SuffixTrie("babc");
		System.out.println(sufTrie.contains("abc"));
	}

}
