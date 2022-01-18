/**
 * There are a row of n houses, each house can be painted with
 *  one of the three colors: red, blue or green. The cost of
 *  painting each house with a certain color is different. 
 *  You have to paint all the houses such that no two adjacent houses 
 *  have the same color, and you need to cost the least. 
 *  Return the minimum cost.

The cost of painting each house with a certain color is 
represented by a n x 3 cost matrix. For example, 
costs[0][0] is the cost of painting house 0 with color red; 
costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
 * 
 * https://www.lintcode.com/problem/515/description
 */

package solutions;

public class PaintHouse {

	public int minCost(int[][] costs) {
		if (costs == null || costs.length == 0)
			return 0;

		int[] totalCost = new int[costs[0].length];
		for (int i = 0; i < costs.length; i++) {
			if (costs[i][0] <= 0 || costs[i][1] <= 0 // costs should strictly be +ve
				|| costs[i][2] <= 0)
				return 0;
			int totalCost0 = costs[i][0]
				+ Math.min(totalCost[1], totalCost[2]);
			int totalCost1 = costs[i][1]
				+ Math.min(totalCost[0], totalCost[2]);
			int totalCost2 = costs[i][2]
				+ Math.min(totalCost[0], totalCost[1]);
			totalCost[0] = totalCost0;
			totalCost[1] = totalCost1;
			totalCost[2] = totalCost2;
		}
		return Math.min(totalCost[0],
			Math.min(totalCost[1], totalCost[2]));
	}

	public static void main(String[] args) {
		int[][] costs = new int[3][3];
		costs[0] = new int[] { 14, 2, 3 };
		costs[1] = new int[] { 11, 14, 5 };
		costs[2] = new int[] { 14, 3, 10 };
		System.out.println(new PaintHouse().minCost(costs));
	}

}
