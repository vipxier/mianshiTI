package Graph;

import java.util.LinkedList;
import java.util.Queue;

class NumberOfIsland {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
        {
            return 0;
        }
        
        Queue<int[]> queue = new LinkedList<int[]>();
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int counter = 0;
        int[] rowAdjustment = new int[] {1, 0, -1, 0};
        int[] colAdjustment = new int[] {0, 1, 0, -1};
        
        for(int i = 0; i < grid.length; i ++)
        {
            for(int j = 0; j < grid[0].length; j ++)
            {
                if(grid[i][j] == '1')
                {
                    counter ++;
                    queue.offer(new int[] {i, j});
                }
            }
        }
        
        while(!queue.isEmpty())
        {
            int[] currentCordinate = queue.poll();
            grid[currentCordinate[0]][currentCordinate[1]] = '0';
                
            for(int i = 0; i < 4; i++)
            {
                if(currentCordinate[0] + rowAdjustment[i] >= 0 && currentCordinate[0] + rowAdjustment[i] < rowLength && currentCordinate[1] + colAdjustment[i] >= 0 && currentCordinate[1] + colAdjustment[i] < colLength && grid[currentCordinate[0] + rowAdjustment[i]][currentCordinate[1] + colAdjustment[i]] == '1')
                {
                    queue.offer(new int[] {currentCordinate[0] + rowAdjustment[i], currentCordinate[1] + colAdjustment[i]});
                }
            }
        }
            
        return counter;
    }
    
    public static void main(String[] args)
    {
    	char[][] map = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    	NumberOfIsland solution = new NumberOfIsland();
    	System.out.println(solution.numIslands(map));
    	
    }
}
