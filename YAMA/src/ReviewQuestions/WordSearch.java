package ReviewQuestions;


public class WordSearch {
	private class Coordinate {
		int x;
		int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private int[] rowAdjustment = new int[] { 0, 1, 0, -1 };
	private int[] colAdjustment = new int[] { 1, 0, -1, 0 };

	public boolean exist(char[][] board, String word) {
		if (word == null || word.length() == 0 || board == null || board.length == 0 || board[0].length == 0) {
			return false;
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					boolean[][] visited = new boolean[board.length][board[0].length];
					visited[i][j] = true;
					if (findWord(board, word, 0, new Coordinate(i, j), visited)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	private boolean findWord(char[][] board, String word, int index, Coordinate coord, boolean[][] visited)
	{
		if(index == word.length())
		{
			return true;
		}
		
		for(int i = 0; i < 4; i++)
		{
			int adjustedRow = coord.x + rowAdjustment[i];
			int adjustedCol = coord.y + colAdjustment[i];
			if(inbound(adjustedRow, adjustedCol, board) && !visited[adjustedRow][adjustedCol] && 
					board[adjustedRow][adjustedCol] == word.charAt(index))
			{
				visited[adjustedRow][adjustedCol] = true;
				if(findWord(board, word, index + 1, new Coordinate(adjustedRow, adjustedCol), visited))
				{
					return true;
				}
				visited[adjustedRow][adjustedCol] = false;
			}
		}
		
		
		return false;
	}

	private boolean inbound(int row, int col, char[][] board) {
		return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
	}
	
	public static void main(String[] args) {
		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		WordSearch solution = new WordSearch();
		System.out.println(solution.exist(board, "ABCCED"));

		// System.out.println(solution.exist(board, "ABCB"));

		char[][] board1 = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' }, { 'A', 'D', 'E', 'E' } };
		System.out.println(solution.exist(board1, "ABCEFSADEESE"));

		char[][] board2 = new char[][] { { 'C', 'A', 'A' }, { 'A', 'A', 'A' }, { 'B', 'C', 'D' } };
		System.out.println(solution.exist(board2, "AAB"));
	}
}
