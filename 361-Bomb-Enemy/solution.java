public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        //like the skyline problem
        //the only difference is we need to consider the left and row
        
        if(grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int[] colHit = new int[grid[0].length];
        int rowHit = 0;
        int max = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(j == 0 || grid[i][j-1] == 'W'){
                    rowHit = 0;
                    for(int k = j; k < grid[0].length && grid[i][k] != 'W'; k++)
                        rowHit += grid[i][k] == 'E'? 1:0;
                }
                if(i == 0 || grid[i-1][j] == 'W'){
                    colHit[j] = 0;
                    for(int k = i; k < grid.length && grid[k][j] != 'W'; k++)
                        colHit[j] += grid[k][j] == 'E'? 1:0;
                }
                if(grid[i][j] == '0')
                    max = Math.max(max, colHit[j]+rowHit);
                    
                // System.out.print(colHit[j]+"+"+rowHit+" ");
            }
            // System.out.println();
        }
        return max;
    }
}