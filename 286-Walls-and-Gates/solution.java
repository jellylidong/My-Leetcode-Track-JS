public class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if(m == 0)  return;
        int n = rooms[0].length;
        if(n == 0)  return;
        
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == 0){
                    // visited[i][j] = true;
                    helper(i+1, j, rooms, visited, 0);
                    helper(i-1, j, rooms, visited, 0);
                    helper(i, j+1, rooms, visited, 0);
                    helper(i, j-1, rooms, visited, 0);
                    // visited[i][j] = false;
                }
            }
        }
    }
    
    public void helper(int i, int j, int[][] rooms, boolean[][] visited, int pre){
        if(i < 0 || i == rooms.length || j < 0 || j == rooms[0].length)
            return;
            
        if(rooms[i][j] == -1 || rooms[i][j] == 0)   return;
        if(visited[i][j])   return;
        
        if(rooms[i][j] > pre+1){
            rooms[i][j] = pre+1;
            visited[i][j] = true;
            helper(i+1, j, rooms, visited, pre+1);
            helper(i-1, j, rooms, visited, pre+1);
            helper(i, j+1, rooms, visited, pre+1);
            helper(i, j-1, rooms, visited, pre+1);
            visited[i][j] = false;
        }
    }
}