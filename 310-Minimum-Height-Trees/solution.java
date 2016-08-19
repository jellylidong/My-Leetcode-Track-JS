public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        //key :node, value nodes connects with key
        
        for(int[] e: edges){
            int v1 = e[0];
            int v2 = e[1];
            if(!map.containsKey(v1))    map.put(v1, new HashSet<Integer>()); 
            if(!map.containsKey(v2))    map.put(v2, new HashSet<Integer>()); 
            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }
        
        List<Integer> leaves = new ArrayList<>();
        if(n == 0)  return leaves;
        if(n == 1){leaves.add(0); return leaves;}
        for(int i = 0; i < n; i++){
            if(map.get(i).size() == 1)
                leaves.add(i);
        }
        
        //remove leves level by level
        int count = n;
        while(count > 2){
            List<Integer> newLeaves = new ArrayList<>();
            for(int l: leaves){
                count--;
                HashSet<Integer> parents = map.get(l);
                for(int p: parents){
                    map.get(p).remove(l);
                    if(map.get(p).size() == 1)
                        newLeaves.add(p);
                }
            }
            leaves = newLeaves;
        }
        
        return leaves;
    }
}