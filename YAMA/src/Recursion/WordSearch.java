package Recursion;

public class WordSearch {
	/**
	 * board = [ ['A','B','C','E'], ['S','F','C','S'], ['A','D','E','E'] ]
	 * 
	 * Given word = "ABCCED", return true. Given word = "SEE", return true. Given
	 * word = "ABCB", return false.
	 */

	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0)
			return false;
		if (word.length() == 0)
			return true;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {

					boolean rst = find(board, i, j, word, 0);
					if (rst)
						return true;
				}
			}
		}
		return false;
	}

	private boolean find(char[][] board, int i, int j, String word, int start) {
		if (start == word.length())
			return true;

		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(start)) {
			return false;
		}

		board[i][j] = '#'; // should remember to mark it
		boolean rst = find(board, i - 1, j, word, start + 1) 
					|| find(board, i, j - 1, word, start + 1)
					|| find(board, i + 1, j, word, start + 1) 
					|| find(board, i, j + 1, word, start + 1);
		board[i][j] = word.charAt(start);
		return rst;
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
