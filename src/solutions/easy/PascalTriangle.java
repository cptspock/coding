package solutions.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it as shown:
 *
 *
 * Example 1:
 * 
 * Input: numRows = 5 Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 
 * Example 2:
 * 
 * Input: numRows = 1 Output: [[1]]
 */
public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		if (numRows == 0)
			return result;
		List<Integer> row = new ArrayList<>();
		row.add(1);
		result.add(row);

		List<Integer> prev = row;
		for (int i = 1; i < numRows; i++) {
			List<Integer> current = new ArrayList<>();
			current.add(1);
			for (int j = 1; j < i; j++) {
				current.add(prev.get(j) + prev.get(j - 1));
			}
			current.add(1);
			result.add(new ArrayList<>(current));
			prev = current;

		}
		return result;
	}

	public static void main(String[] args) {
		List<List<Integer>> result = new PascalTriangle().generate(5);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

}
