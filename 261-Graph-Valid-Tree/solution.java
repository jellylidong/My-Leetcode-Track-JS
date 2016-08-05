public class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] root = new int[n]; //root[i] is i's parent
        Arrays.fill(root, -1);
        
        for(int[] pair:edges){
            int n1 = pair[0];
            int n2 = pair[1];
            
            int r1 = find(root, n1);
            int r2 = find(root, n2);
            
            if(r1 == r2)    return false;
            else{
                if(r1 < r2) root[r1] = r2;
                else    root[r2] = r1;
            }
        }
        
        return n-1 == edges.length;
    }
    
    public int find(int[] root, int target){
        if(root[target] == -1)  return target;
        return find(root, root[target]);
    }
}