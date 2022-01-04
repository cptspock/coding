/**
 * 	A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. 
 * 	There are various applications of this data structure, such as autocomplete and spellchecker.

	Implement the Trie class:
	- Trie() Initializes the trie object.
	- void insert(String word) Inserts the string word into the trie.
	- boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
	- boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 *
 * 
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */

package solutions;

import java.util.HashMap;
import java.util.Map;

public class PrefixTrie {
	private class TrieNode {
		Map<Character, TrieNode> children = new HashMap<>();
	}

	private TrieNode root;
	private char endSymbol = '*'; // symbol to denote end of word

	public PrefixTrie() {
		root = new TrieNode();
	}

	private void insert(String str) {
		TrieNode curr = root;
		for (char letter : str.toCharArray()) {
			if (curr.children.get(letter) == null) {
				curr.children.put(letter, new TrieNode());
			}
			curr = curr.children.get(letter);
		}
		curr.children.put(endSymbol, null);
	}

	public boolean contains(String str) {
		TrieNode lastCharNode = containsHelper(str);
		return lastCharNode != null ? lastCharNode.children.containsKey(endSymbol) : false;
	}

	private TrieNode containsHelper(String str) {
		TrieNode curr = root;
		for (char letter : str.toCharArray()) {
			if (curr.children.get(letter) == null) {
				return null;
			}
			curr = curr.children.get(letter);
		}
		return curr;
	}

	public boolean startsWith(String str) {
		TrieNode lastCharNode = containsHelper(str);
		return lastCharNode != null;
	}

	public static void main(String[] args) {
		PrefixTrie prefixTree = new PrefixTrie();
		prefixTree.insert("babc");
		System.out.println(prefixTree.contains("abc"));
		System.out.println(prefixTree.startsWith("bab"));
	}

}
