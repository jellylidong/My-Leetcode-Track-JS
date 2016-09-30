public class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        int lo = 0;
        int max = 0;
        for(int hi = 0; hi < s.length(); hi++){
            char c = s.charAt(hi);
            if(map.containsKey(c)){
                lo = Math.max(lo, map.get(c)+1);
            }
            map.put(c, hi);
            max = Math.max(max, hi-lo+1);
        }
        return max;
    }
}