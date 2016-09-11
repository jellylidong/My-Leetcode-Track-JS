public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] query) {
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        for(int i = 0; i < equations.length; i++){
            String s1 = equations[i][0];
            String s2 = equations[i][1];
            if(!map.containsKey(s1))    map.put(s1, new HashMap<String, Double>());
            map.get(s1).put(s2, values[i]);
            if(!map.containsKey(s2))    map.put(s2, new HashMap<String, Double>());
            map.get(s2).put(s1, 1.0/values[i]);
        }
        
        double[] ans = new double[query.length];
        HashSet<String> visited = new HashSet<>();
        for(int i = 0; i < query.length; i++){
            String s1 = query[i][0];
            String s2 = query[i][1];
            Double res1 = dfs(s1, s2, map, visited);
            Double res2 = null;
            if(res1 == null)    res2 = dfs(s2, s1, map, visited);
            ans[i] = res1 == null? (res2 == null? -1.0: 1.0/res2) : res1;
        }
        return ans;
    }
    
    public Double dfs(String begin, String end, HashMap<String, HashMap<String, Double>> map, HashSet<String> visited){
        if(visited.contains(begin + "/" + end))  return null;
        if(!map.containsKey(begin)) return null;
        if(begin.equals(end))   return 1.0;
        if(map.containsKey(begin) && map.get(begin).containsKey(end))  return map.get(begin).get(end);
        // if(map.containsKey(end) && map.get(end).containsKey(begin))  return 1.0/map.get(end).get(begin);
        else{
            Double res = null;
            for(String s: map.get(begin).keySet()){
                visited.add(begin + "/" + end);
                visited.add(end + "/" + begin);
                res = dfs(s, end, map, visited);
                visited.remove(begin + "/" + end);
                visited.remove(end + "/" + begin);
                if(res != null) {
                    res = map.get(begin).get(s) * res;
                    break;
                }
            }
            return res;
        }
    }
}