package interview;

public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int numOfIslands = 0;
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1')
					numOfIslands += exploreIsland(grid, i, j);
			}
		return numOfIslands;
	}
	
	private int exploreIsland(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
			return 0;
		grid[i][j] = '0';
		exploreIsland(grid, i + 1, j);
		exploreIsland(grid, i - 1, j);
		exploreIsland(grid, i, j + 1);
		exploreIsland(grid, i, j - 1);
		return 1;
	}

	public static void main(String[] args) {
		//char[][] grid = new char[4][5];
		char[][] grid = { {'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
		System.out.println(new NumberOfIslands().numIslands(grid));
	}

}
