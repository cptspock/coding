package interview;

/** 
 * https://leetcode.com/problems/asteroid-collision/
 * 
 * Input: 
	asteroids = [5, 10, -5]
	Output: [5, 10]
	Explanation: 
	The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
	
	Example 2:
	Input: 
	asteroids = [8, -8]
	Output: []
	Explanation: 
	The 8 and -8 collide exploding each other.
	
	Example 3:
	Input: 
	asteroids = [10, 2, -5]
	Output: [10]
	Explanation: 
	The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.
	
	Example 4:
	Input: 
	asteroids = [-2, -1, 1, 2]
	Output: [-2, -1, 1, 2]
	Explanation: 
	The -2 and -1 are moving left, while the 1 and 2 are moving right.
	Asteroids moving the same direction never meet, so no asteroids will meet each other.
 */
import java.util.Stack;

public class AsteroidCollision {
	public int[] asteroidCollison(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < asteroids.length; i++) {
			int current = asteroids[i];
			if (stack.isEmpty() || current > 0) {
				stack.push(current);
			} else {
				while (true) {
					int top = stack.peek();
					if (top < 0) {
						stack.push(current);
						break;
					} else if (top == Math.abs(current)) {
						stack.pop();
						break;
					} else if (top > Math.abs(current)) {
						break;
					} else { // top < Math.abs(current)
						stack.pop();
						if (stack.isEmpty()) {
							stack.push(current);
						}
					}
				}
			}
		}

		int[] result = new int[stack.size()];
		for (int i = stack.size() - 1; i >= 0; i--) {
			result[i] = stack.pop();
		}
		return result;
	}

	public static void main(String[] args) {
		int[] res = new AsteroidCollision().asteroidCollison(new int[] { 10, 2, -5 });
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
}
