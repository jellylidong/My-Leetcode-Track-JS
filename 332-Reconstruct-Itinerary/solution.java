public class Solution {
    HashMap<String, PriorityQueue<String>> map;
    List<String> ans;
    public List<String> findItinerary(String[][] tickets) {
        ans = new ArrayList<>();
        map = new HashMap<>();

        for(String[] t: tickets){
            if(!map.containsKey(t[0]))  map.put(t[0], new PriorityQueue<String>());
            map.get(t[0]).offer(t[1]);
        }
        
        visit("JFK");
        
        Collections.reverse(ans); //since we are doing DFS, so the ending will be add to the list first
        return ans;
    }
    
    public void visit(String cur){
        //there can be airport that we only go to, not go from
        //so we msut check map.containsKey() first
        while(map.containsKey(cur) && !map.get(cur).isEmpty())
            visit(map.get(cur).poll());
        ans.add(cur);
    }
}