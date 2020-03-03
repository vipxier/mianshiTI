package OA;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private class Coordinate
    {
        int x;
        int y;
        
        public Coordinate(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    
    private int[] rowAdjustment = new int[] {0, 1, 0, -1};
    private int[] colAdjustment = new int[] {1, 0, -1, 0};
    
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length ==0 || grid[0].length == 0)
        {
            return -1;
        }
        
        Queue<Coordinate> queue = new LinkedList<Coordinate>();
        int freshOrangeCount = 0;
        int minutesCount = 0;
        
        for(int i = 0; i < grid.length; i ++)
        {
            for(int j = 0; j < grid[0].length; j ++)
            {
                if(grid[i][j] == 2)
                {
                    queue.offer(new Coordinate(i, j));
                }
                else if(grid[i][j] == 1)
                {
                    freshOrangeCount ++;                
                }
            }
        }
        
        
        if(freshOrangeCount == 0)
        {
            return 0;
        }
            
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0; i < size; i ++)
            {
                Coordinate currentCoord = queue.poll();
                    
                for(int index = 0; index < 4; index ++)
                {
                   int adjustedRow = currentCoord.x + rowAdjustment[index];
                    int adjustedCol = currentCoord.y + colAdjustment[index];            
                    if(inbound(adjustedRow, adjustedCol, grid) && grid[adjustedRow][adjustedCol] == 1)
                    {
                        grid[adjustedRow][adjustedCol] = 2;
                        queue.offer(new Coordinate(adjustedRow, adjustedCol));
                        freshOrangeCount --;
                    }
                }
            }
            minutesCount ++;
        }
        
        return freshOrangeCount == 0 ? minutesCount - 1 : -1;
    }
    
    private boolean inbound(int row, int col, int[][] grid)
    {
        return row >=0 && row < grid.length && col >=0 && col < grid[0].length;
    }
}