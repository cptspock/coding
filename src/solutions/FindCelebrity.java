/** 
 * https://www.lintcode.com/problem/645/description
 * 
 */
package solutions;

public class FindCelebrity {
	/*
	 * The knows API is defined in the parent class Relation. boolean knows(int a,
	 * int b); if a knows b return true else return false
	 */

	// O(n^2) time due to nested for loops
	public int findCelebrity(int n) {
		for (int i = 0; i < n; i++) {
			if (isCeleb(i, n))
				return i;
		}
		return -1;
	}

	// O(n) time
	public int findCelebrity2(int n) {
		int possible_celeb = 0;
		for (int i = 1; i < n; i++) {
			if (knows(possible_celeb, i)) {
				possible_celeb = i;
			}
		}
		if (isCeleb(possible_celeb, n)) {
			return possible_celeb;
		}
		return -1;
	}

	private boolean isCeleb(int possible_celeb, int n) {
		for (int j = 0; j < n; j++) {
			if (j == possible_celeb)
				continue;
			if (knows(possible_celeb, j)
				|| !knows(j, possible_celeb)) {
				return false;
			}
		}
		return true;
	}

	// dummy method in order for code to compile
	private boolean knows(int a, int b) {
		return false;
	}
}
