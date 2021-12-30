package interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		Map<Integer, HashSet<Character>> row = new HashMap<>(9);
		Map<Integer, HashSet<Character>> col = new HashMap<>(9);
		Map<Integer, HashSet<Character>> box = new HashMap<>(9);
        
        for (int i = 0 ; i < 9; ++i) {
            row.put(i, new HashSet<Character>());
            col.put(i, new HashSet<Character>());
            box.put(i, new HashSet<Character>());
        }
        
        for (int i = 0 ; i < 9 ; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') continue;
                HashSet<Character> set = row.get(i);
                if (!set.add(board[i][j])) return false;

                set = col.get(j);
                if (!set.add(board[i][j])) return false;
                
                int boxIdx = (i / 3) * 3 + (j / 3);
                set = box.get(boxIdx);
                if (!set.add(board[i][j])) return false;
                
            }
        }
        return true;

	}
	
	public boolean isValidSudoku2(char[][] board) {
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				if (board[r][c] != '.') {
					if (!isValid(board, r, c, board[r][c])) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	private boolean isValid(char[][] board, int r, int c, char value) {
		// check the row
		for (int j = 0; j < 9; j++)
			if (j != c && board[r][j] == value)
				return false;
		
		// check the column
		for (int i = 0; i < 9; i++)
			if (i != r && board[i][c] == value)
				return false;
		
		// check box (3x3)
		int boxStartRowIdx = 3 * (r / 3);
		int boxStartColIdx = 3 * (c / 3);
		
		for (int i = boxStartRowIdx; i < boxStartRowIdx + 3; i++)
			for (int j = boxStartColIdx; j < boxStartColIdx + 3; j++)
				if (i != r && j != c && board[i][j] == value)
					return false;
		return true;
	}
	
	public static void main(String[] args) {
		char[][] input = new char[9][9];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                input[i][j] = '.';
            }
        }

        input[0] = "..9748...".toCharArray();
        input[1] = "7........".toCharArray();
        input[2] = ".2.1.9...".toCharArray();
        input[3] = "..7...24.".toCharArray();
        input[4] = ".64.1.59.".toCharArray();
        input[5] = ".98...3..".toCharArray();
        input[6] = "...8.3.2.".toCharArray();
        input[7] = "........6".toCharArray();
        input[8] = "...2759..".toCharArray();
        System.out.println(new ValidSudoku().isValidSudoku(input));
	}

}
