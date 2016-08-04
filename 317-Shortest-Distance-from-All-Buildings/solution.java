public class Solution {
    
    /*
    start from a building (ie grid[i][j] == 1)
    BFS all its empty neighbors (ie grid[i][j] == 0)
    for each level of BFS, the level number is the ditance from the build to current position
    meanwhile,  we need to maintain a timeVisited array to memorize how many times current position is visited
    if grid[i][j] == 0  and timeVisited[i][j] == number of buildings
    it means current empty position is accessible to all buildings
    
    besides, we also need to declare a new visited array 
    to memorize if current positon has been visited evert time we need to start a new BFS
    to avoid going back
    */
    
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        if(m == 0)  return 0;
        int n = grid[0].length;
        if(n == 0)  return 0;
        
        int[][] distance = new int[m][n];
        int[][] timeVisited = new int[m][n];
        
        int roomCount = 0; // number of rooms
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    roomCount++;
                    boolean[][] visited = new boolean[m][n];
                    Queue<Pos> q = new LinkedList<>();
                    q.offer(new Pos(i, j));
                    int curD = 0; //current distance from grid[i][j]
                    
                    while(!q.isEmpty()){
                        int size = q.size();
                        for(int k = 0; k < size; k++){
                            Pos curP = q.poll();
                            int curX = curP.x;
                            int curY = curP.y;
                            visited[curX][curY] = true;
                            timeVisited[curX][curY]++;
                            distance[curX][curY] += curD;
                            
                            if(curX-1 >= 0 && !visited[curX-1][curY] && grid[curX-1][curY] == 0){
                                visited[curX-1][curY] = true;
                                q.offer(new Pos(curX-1, curY));
                            }
                            if(curX+1 < grid.length && !visited[curX+1][curY] && grid[curX+1][curY] == 0){
                                visited[curX+1][curY] = true;
                                q.offer(new Pos(curX+1, curY));
                            }
                            if(curY-1 >= 0 && !visited[curX][curY-1] && grid[curX][curY-1] == 0){
                                visited[curX][curY-1] = true;
                                q.offer(new Pos(curX, curY-1));
                            }
                            if(curY+1 < grid[0].length && !visited[curX][curY+1] && grid[curX][curY+1] == 0){
                                visited[curX][curY+1] = true;
                                q.offer(new Pos(curX, curY+1));
                            }
                        }
                        curD++;
                    }
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0 && timeVisited[i][j] == roomCount)
                    min = Math.min(min, distance[i][j]);
            }
        }
        
        return min == Integer.MAX_VALUE? -1:min;
    }
    
    public class Pos{
        int x,y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}