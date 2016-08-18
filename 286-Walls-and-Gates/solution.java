public class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if(m == 0)  return;
        int n = rooms[0].length;
        if(n == 0)  return;
        
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == 0)
                    q.offer(new int[] {i, j});
            }
        }
        
        int inf = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                int row = cur[0];
                int col = cur[1];
                if(row-1 >= 0 && rooms[row-1][col] == inf){
                    rooms[row-1][col] = rooms[row][col]+1;
                    q.offer(new int[] {row-1, col});
                }
                if(row+1 < m && rooms[row+1][col] == inf){
                    rooms[row+1][col] = rooms[row][col]+1;
                    q.offer(new int[] {row+1, col});
                }
                if(col-1 >= 0 && rooms[row][col-1] == inf){
                    rooms[row][col-1] = rooms[row][col]+1;
                    q.offer(new int[] {row, col-1});
                }
                if(col+1 < n && rooms[row][col+1] == inf){
                    rooms[row][col+1] = rooms[row][col]+1;
                    q.offer(new int[] {row, col+1});
                }
            }
        }
    }
}