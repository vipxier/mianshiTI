import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindWord2 {
	public List<String> findWords(char[][] board, String[] words) {
		if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0)
        {
            return new ArrayList<String>();
        }
     
        boolean[][] visited = new boolean[board.length][board[0].length];
        Map<String, Boolean> prefixIsMatch = getPrefixIsMatchMap(words);
        Set<String> hashSet = new HashSet<String>();
        for(int i = 0; i < board.length; i ++)
        {
            for(int j = 0; j < board[0].length; j ++)
            {
                visited[i][j] = true;
                findMatch(board, visited, prefixIsMatch, i, j, String.valueOf(board[i][j]), hashSet);
                visited[i][j] = false;
            }
        }
        
        return new ArrayList<String>(hashSet);
    }
    
    private void findMatch(char[][] board, boolean[][] visited, Map<String, Boolean> prefixIsMatch, int rowIndex, int colIndex, String prefix, Set<String> hashSet)
    {
        if(!prefixIsMatch.containsKey(prefix))
        {
            return; 
        }
        
        if(prefixIsMatch.get(prefix))
        {
            hashSet.add(prefix);
        }
        
        int[] rowChange = new int[] {1, 0, -1, 0};
        int[] colChange = new int[] {0, -1, 0, 1};
        for(int i = 0; i < 4; i ++)
        {
            int adjustedRowIndex = rowIndex + rowChange[i];
            int adjustedColIndex = colIndex + colChange[i];
            
            if(!inBoard(board, adjustedRowIndex, adjustedColIndex) || visited[adjustedRowIndex][adjustedColIndex])
            {
                continue;
            }
            
            visited[adjustedRowIndex][adjustedColIndex] = true;
            findMatch(board, visited, prefixIsMatch, adjustedRowIndex, adjustedColIndex, prefix + board[adjustedColIndex][adjustedColIndex], hashSet);
            visited[adjustedRowIndex][adjustedColIndex] = false;
        }
    }
    
    private Map<String, Boolean> getPrefixIsMatchMap(String[] words)
    {
        Map<String, Boolean> result = new HashMap<>();
        for(String word : words)
        {
            for(int i = 0; i < word.length() - 1; i ++)
            {
                String prefix = word.substring(0, i + 1);
                if(!result.containsKey(prefix)){
                    result.put(prefix, false);
                }
            }
            result.put(word, true);
        }
        
        return result;
    }
    
    private boolean inBoard(char[][] board, int rowIndex, int colIndex)
    {
        return rowIndex >=0 && colIndex >= 0 && rowIndex < board.length && colIndex < board[0].length;
    }
}
