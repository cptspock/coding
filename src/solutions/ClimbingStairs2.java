package solutions;

/**
 * https://leetcode.com/problems/climbing-stairs/
 * 
 * You are climbing a staircase. It takes n steps to reach the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 */
public class ClimbingStairs2 {

	public static int calculateNumberOfWays(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;

		int step1 = 1;
		int step2 = 1;
		int numberOfWays = 0;

		for (int i = 2; i <= n; i++) {
			numberOfWays = step1 + step2;
			step1 = step2;
			step2 = numberOfWays;
		}
		return numberOfWays;
	}

	public static void main(String[] args) {
		System.out.println(ClimbingStairs2.calculateNumberOfWays(3));
	}
}
