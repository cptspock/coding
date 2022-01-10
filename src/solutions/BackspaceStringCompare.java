/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

 * https://leetcode.com/problems/backspace-string-compare/
 */

package solutions;

public class BackspaceStringCompare {
	public boolean backspaceCompare(String s, String t) {
		StringBuilder sb1 = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (c != '#') {
				sb1.append(c);
			} else if (sb1.length() != 0){
				sb1.deleteCharAt(sb1.length() - 1);
			}
		}
		StringBuilder sb2 = new StringBuilder();
		for (char c : t.toCharArray()) {
			if (c != '#') {
				sb2.append(c);
			} else  if (sb2.length() != 0) {
				sb2.deleteCharAt(sb2.length() - 1);
			}
		}
		return sb1.toString().equals(sb2.toString());
	}
	
	/**
	 * O(1) space solution
	 * @param args
	 */
	public boolean backspaceCompare2(String s, String t) {
		int i = s.length() - 1;
		int j = t.length() - 1;
		int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char to compare
                if (s.charAt(i) == '#') {
                	skipS++; 
                	i--;
                }
                else if (skipS > 0) {
                	skipS--; 
                	i--;
                }
                else break; // no # found
            }
            while (j >= 0) { // Find position of next possible char to compare
                if (t.charAt(j) == '#') {
                	skipT++; 
                	j--;
                }
                else if (skipT > 0) {
                	skipT--; 
                	j--;
                }
                else break; // no # found
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j))
                return false;
            // If expecting to compare char vs nothing 
            if ((i >= 0 && j < 0) || (i < 0 && j >= 0))
                return false;
            i--; 
            j--;
        }
        return true;

	}

	public static void main(String[] args) {
		//System.out.println(new BackspaceStringCompare().backspaceCompare2("a#b#a#f#c", "c"));
		//System.out.println(new BackspaceStringCompare().backspaceCompare2("a#b#", "c#"));
		System.out.println(new BackspaceStringCompare().backspaceCompare2("a#b#", "c"));
	}

}
