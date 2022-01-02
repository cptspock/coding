/**
 * https://leetcode.com/problems/diagonal-traverse/
 */
package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiagonalTraverse {
	public int[] findDiagonalOrder(int[][] mat) {
		if (mat == null || mat.length == 0) {
			return new int[0];
		}
		int rows = mat.length; // # of rows
		int cols = mat[0].length; // # of cols
		List<Integer> intermediate = new ArrayList<>();
		int row = 0, col = 0;
		int k = 0;
		int[] result = new int[rows * cols];

		for (int d = 0; d < rows; d++) {
			intermediate.clear();
			row = d;
			col = 0;
			while (row >= 0 && col < cols) {
				intermediate.add(mat[row][col]);
				row--;
				col++;
			}
			if (d % 2 != 0) Collections.reverse(intermediate);
			for (int i = 0; i < intermediate.size(); i++)
				result[k++] = intermediate.get(i);
		}
		for (int d = 1; d < cols; d++) {
			intermediate.clear();
			row = rows - 1;
			col = d;
			while (row >= 0 && col < cols) {
				intermediate.add(mat[row][col]);
				row--;
				col++;
			}
			if (d % 2 != 0) Collections.reverse(intermediate);
			for (int i = 0; i < intermediate.size(); i++)
				result[k++] = intermediate.get(i);
		}
		
		return result;
	}

	public static void main(String[] args) {
		//int[][] array ={ {1,2,3},{8,9,4},{7,6,5}};
		//int[][] array = {{ 1, 2, 3 }, { 12, 13, 4 }, { 11, 14, 5 }, { 10, 15, 6 }, { 9, 8, 7 }};
		int[][] array ={ {1,2,3, 4},{10,11,12,5},{9,8,7,6}};
		
		int[] result = new DiagonalTraverse().findDiagonalOrder(array);
		for (int i = 0; i < result.length; i++)
			System.out.println(result[i]);
	}

}
