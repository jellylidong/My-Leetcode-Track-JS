public class Solution {
    //for a 1D array, if its 1st 1 is at i, last 1 at j, then any point between i and j can make the same distance sum
    //is |k-i| + |j-k| = j-i is, constant
    //any other position < i or > j makes overlap, and longer distance
    //so we don't have to knwo what the point is
    //we only need to know find all 1s positon in each row and let last-first, (last-1) - (first+1)...
    //so for columns
    public int minTotalDistance(int[][] grid) {
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        
        return calDist(row) + calDist(col);
    }
    
    public int calDist(List<Integer> list){
        Collections.sort(list);
        int lo = 0;
        int hi = list.size()-1;
        
        int dist = 0;
        while(lo < hi){
            dist += list.get(hi) - list.get(lo);
            hi--;
            lo++;
        }
        return dist;
    }
}