/**
 * https://leetcode.com/problems/spiral-matrix-ii/
 */

package solutions;

public class SpiralTraverse2 {
	public int[][] spiralTraverse(int n) {
		int start = 0, end = n - 1;
		int value = 1;
		int[][] array = new int[n][n];
		while (start <= end) {
			for (int col = start; col <= end; col++) {
				array[start][col] = value++;
			}
			for (int row = start + 1; row <= end; row++) {
				array[row][end] = value++;
			}
			for (int col = end - 1; col >= start; col--) {
				array[end][col] = value++;
			}
			for (int row = end - 1; row > start; row--) {
				array[row][start] = value++;
			}
			start += 1;
			end -= 1;
		}
		return array;
	}

	public static void main(String[] args) {
		// int[][] array ={ {1,2,3},{8,9,4},{7,6,5}};
		// int[][] array ={ {1,2,3,4},{10,11,12,5},{9,8,7,6}}; // startRow == endRow
		// check

		// check
		int[][] result = new SpiralTraverse2().spiralTraverse(0);

		
		 for (int i = 0; i < result.length; i++)
			 for (int j = 0; j < result.length; j++)
		     { 
				 System.out.println(result[i][j]); 
		     }
		 
	}

}
