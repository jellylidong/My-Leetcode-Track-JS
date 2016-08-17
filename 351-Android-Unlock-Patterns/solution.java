public class Solution {
    public int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = 
        skip[3][7] = skip[7][3] = 
        skip[4][6] = skip[6][4] = 
        skip[2][8] = skip[8][2] = 5;
        
        boolean[] visited = new boolean[10];
        
        int ans = 0;
        for(int i = m; i <= n; i++){
            ans += helper(1, i-1, visited, skip) * 4;
            ans += helper(2, i-1, visited, skip) * 4;
            ans += helper(5, i-1, visited, skip);
        }
        
        return ans;
    }
    
    public int helper(int curP, int remain, boolean[] visited, int[][] skip){
        if(remain == 0) return 1;
        
        int ans = 0;
        visited[curP] = true;
        for(int i = 1; i <= 9; i++){
            //!!! remeber the dfs condition
            //1st make sure next position has not been visited
            //2.1 we can go from current position to next position withough cover any other position
            //e.g we go from 1 to 3, we have to go though 2, 
            //so skip[i][j] == 0 means we can go from i to j without cover other position
            //2.2 or we can go from i to j that covers other position, but this position is already taken
            //e.g we go from 1 to 3, if 2 is already taken, then we can go
            if(!visited[i] && (skip[curP][i] == 0 || visited[skip[curP][i]]))
                ans += helper(i, remain-1, visited, skip);
        }
        visited[curP] = false;
        return ans;
    }
}