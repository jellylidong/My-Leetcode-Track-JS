public class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] root = new int[n]; //root[i] is i's parent
        // Arrays.fill(root, -1);
        for(int i = 0; i < n; i++)
            root[i] = i;
        
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
        //can not return true directly
        //for a valid graph tree, there are two conditions
        //1.no circle
        //2.all nodes are connected, not isolated
        return n-1 == edges.length;
    }
    
    public int find(int[] root, int target){
        while(target != root[target]){
            int father = root[root[target]];
            root[target] = father;
            target = root[target];
        }
        return target;
    }
}