/**
 * There is a robot starting at the position (0, 0), the origin, on a 2D plane. 
 * Given a sequence of its moves, judge if this robot ends up at (0, 0) after it 
 * completes its moves.

You are given a string moves that represents the move sequence of the robot 
where moves[i] represents its ith move. Valid moves are 'R' (right), 'L' (left), 
'U' (up), and 'D' (down).

Return true if the robot returns to the origin after it finishes all of its moves,
or false otherwise.
 * 
 * https://leetcode.com/problems/robot-return-to-origin/
 */
package solutions;

public class RobotReturnToOrigin {

	public boolean judgeCircle(String moves) {
		if (moves == null) // if empty string then return statement
							// automatically takes care of it. Clarify with interviewer about this
							// and null string if needed
			return false;
		int x = 0, y = 0;
		for (char move : moves.toCharArray()) {
			switch (move) {
			case 'R':
				x++;
				break;
			case 'L':
				x--;
				break;
			case 'U':
				y++;
				break;
			case 'D':
				y--;
				break;
			}

		}
		return x == 0 && y == 0;
	}

	public static void main(String[] args) {
		System.out.println(
			new RobotReturnToOrigin().judgeCircle("RUDL"));
	}

}
