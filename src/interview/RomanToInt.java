package interview;

// https://leetcode.com/problems/roman-to-integer/
import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
	public int converRomanToInt(String str) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			if (i > 0 && map.get(str.charAt(i)) > map.get(str.charAt(i - 1))) {
				result += map.get(str.charAt(i)) - 2 * map.get(str.charAt(i - 1));
			} else {
				result += map.get(str.charAt(i));
			}
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.print(new RomanToInt().converRomanToInt("CCXLVIII"));
	}

}
