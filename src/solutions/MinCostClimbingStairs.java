package solutions;

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on
 * a staircase. Once you pay the cost, you can either climb one or two steps.
 * 
 * You can either start from the step with index 0, or the step with index 1.
 * 
 * Return the minimum cost to reach the top of the floor.
 * 
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 * 
 * 
 */
public class MinCostClimbingStairs {

	public static int calculateMinCostClimbingStairs(int[] cost) {
		int length = cost.length;
		for (int i = 2; i < length; i++) {
			cost[i] = cost[i] + Math.min(cost[i - 1], cost[i - 2]);
		}
		return Math.min(cost[length - 1], cost[length - 2]);

	}

	public static void main(String[] args) {
		System.out.println(MinCostClimbingStairs.calculateMinCostClimbingStairs(
			new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }));

	}

}
