public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        
        int s = 0;
        int e = 0;
        for(; e < str.length(); e++){
            char c = str.charAt(e);
            if(!map.containsKey(c)) map.put(c, 1);
            else map.put(c, map.get(c)+1);
            
            if(map.size() > 2){
                for(; map.size() > 2; s++){
                    char c2 = str.charAt(s);
                    map.put(c2, map.get(c2)-1);
                    if(map.get(c2) == 0)
                        map.remove(c2);
                }
            }
            
            max = Math.max(max, e-s+1);
        }
        
        return max;
    }
}