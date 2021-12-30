package interview;

// https://leetcode.com/problems/integer-to-roman/

public class IntToRoman {
	public String convertIntToRoman(int num) {
		int[] intValues = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] romanValues = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < intValues.length; i++) {
			int value = intValues[i];
			while (num >= value) {
				num -= value;
				result.append(romanValues[i]);
				if (num == 0) return result.toString();
			}
		}
		return null;
	}
	
	public String convertIntToRoman2(int num) {
		String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
		String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
		String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
		String[] thousands = {"", "M", "MM", "MMM"};
		
		return thousands[num / 1000] + hundreds[(num % 1000) / 100] + tens[(num % 100) / 10] + units[num % 10];
	}

	public static void main(String[] args) {
		String input = "aaa";
		System.out.println(new IntToRoman().convertIntToRoman(1994));
		System.out.println(new IntToRoman().convertIntToRoman2(1994));
	}

}
