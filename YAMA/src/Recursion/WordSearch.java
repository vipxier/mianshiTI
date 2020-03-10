package Recursion;

public class WordSearch {
	/**
	 * board = [ ['A','B','C','E'], ['S','F','C','S'], ['A','D','E','E'] ]
	 * 
	 * Given word = "ABCCED", return true. Given word = "SEE", return true. Given
	 * word = "ABCB", return false.
	 */
	private int[] rowAdjustment = new int[] { 0, 1, 0, -1 };
	private int[] colAdjustment = new int[] { 1, 0, -1, 0 };

	private class Coordinate {
		int x;
		int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public boolean exist(char[][] board, String word) {
		if (word == null || word.length() == 0 || board == null || board.length == 0 || board[0].length == 0) {
			return false;
		}

		boolean[][] visited = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (findWord(visited, board, word, 1, new Coordinate(i, j))) {
						return true;
					}
				}

				visited = new boolean[board.length][board[0].length];
			}
		}

		return false;
	}

	private boolean findWord(boolean[][] visited, char[][] board, String word, int index, Coordinate coor) {
		if (word.length() == index) {
			return true;
		}

		visited[coor.x][coor.y] = true;
		for (int i = 0; i < 4; i++) {
			int adjustedRow = coor.x + rowAdjustment[i];
			int adjustedCol = coor.y + colAdjustment[i];
			if (inbound(adjustedRow, adjustedCol, board) && !visited[adjustedRow][adjustedCol]
					&& word.charAt(index) == board[adjustedRow][adjustedCol]) {
				if (findWord(visited, board, word, index + 1, new Coordinate(adjustedRow, adjustedCol))) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean inbound(int row, int col, char[][] board) {
		return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
	}

	public static void main(String[] args) {
		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' },
										{ 'S', 'F', 'C', 'S' },
										{ 'A', 'D', 'E', 'E' } };
		WordSearch solution = new WordSearch();
		System.out.println(solution.exist(board, "ABCCED"));

		System.out.println(solution.exist(board, "ABCB"));
		
		char[][] board1 = new char[][] { { 'A', 'B', 'C', 'E' },
										 { 'S', 'F', 'E', 'S' },
										 { 'A', 'D', 'E', 'E' } };
		System.out.println(solution.exist(board1, "ABCEFSADEESE"));
	}
}
