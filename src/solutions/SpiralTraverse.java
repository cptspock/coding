/**
 * https://leetcode.com/problems/spiral-matrix/
 * https://www.algoexpert.io/questions/Spiral%20Traverse
 */

package solutions;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
	public List<Integer> spiralTraverse(int[][] array) {
		List<Integer> result = new ArrayList<>();
		if (array == null || array.length == 0) 
			return result;
		int startRow = 0, 
			endRow = array.length - 1, 
			startCol = 0, 
			endCol = array[0].length - 1; // important since # of rows may not be = # of cols

		while (startRow <= endRow && startCol <= endCol) {
			for (int col = startCol; col <= endCol; col++) {
				result.add(array[startRow][col]);
			}
			for (int row = startRow + 1; row <= endRow; row++) {
				result.add(array[row][endCol]);
			}
			for (int col = endCol - 1; col >= startCol; col--) {
				if (startRow == endRow)
					break;
				result.add(array[endRow][col]);
			}
			for (int row = endRow - 1; row > startRow; row--) {
				if (startCol == endCol)
					break;
				result.add(array[row][startCol]);
			}
			startRow += 1;
			startCol += 1;
			endRow -= 1;
			endCol -= 1;
		}
		return result;
	}

	public static void main(String[] args) {
		// int[][] array ={ {1,2,3},{8,9,4},{7,6,5}};
		// int[][] array ={ {1,2,3,4},{10,11,12,5},{9,8,7,6}}; // startRow == endRow
		// check
		int[][] array = { { 1, 2, 3 }, { 12, 13, 4 }, { 11, 14, 5 }, { 10, 15, 6 }, { 9, 8, 7 } }; // startCol == endCol
																									// check
		List<Integer> result = new SpiralTraverse().spiralTraverse(null);
		for (Integer i : result) {
			System.out.println(i);
		}

	}

}
