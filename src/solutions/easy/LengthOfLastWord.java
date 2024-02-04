package solutions.easy;

/**
 * 
 * https://leetcode.com/problems/length-of-last-word/description/
 * 
 * Given a string s consisting of words and spaces, return the length of the
 * last word in the string.
 * 
 * A word is a maximal substring consisting of non-space characters only.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "Hello World" Output: 5 Explanation: The last word is "World" with
 * length 5.
 * 
 * Example 2:
 * 
 * Input: s = " fly me to the moon " Output: 4 Explanation: The last word is
 * "moon" with length 4.
 * 
 * Example 3:
 * 
 * Input: s = "luffy is still joyboy" Output: 6 Explanation: The last word is
 * "joyboy" with length 6.
 *
 */
public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {
		int result = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ' && result > 0) {
				break;
			} else if (s.charAt(i) == ' ' && result == 0) {
				continue;
			} else {
				result++;
			}

		}
		return result;

	}

	public static void main(String[] args) {
		System.out.println(
			new LengthOfLastWord().lengthOfLastWord("luffy is still joyboy"));
		System.out.println(
			new LengthOfLastWord().lengthOfLastWord(" fly me to the moon "));
	}

}
