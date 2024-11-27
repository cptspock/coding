package solutions.easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

	public boolean isIsomorphic(String s, String t) {
		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				if (!map.get(s.charAt(i)).equals(t.charAt(i))) {
					return false;
				}
			} else if (map.containsValue(t.charAt(i))) {
				return false;
			} else {
				map.put(s.charAt(i), t.charAt(i));
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out
			.println(new IsomorphicStrings().isIsomorphic("paper", "title"));
		System.out.println(new IsomorphicStrings().isIsomorphic("foo", "bar"));
		System.out.println(new IsomorphicStrings().isIsomorphic("foo", "foo"));
	}

}
