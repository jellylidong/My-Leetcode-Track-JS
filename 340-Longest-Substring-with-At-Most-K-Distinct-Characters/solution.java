public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)) map.put(c, 1);
            else map.put(c, map.get(c)+1);
            if(map.size() > k){
                for(; map.size() > k; start++){
                    char c2 = s.charAt(start);
                    map.put(c2, map.get(c2)-1);
                    if(map.get(c2) == 0)
                        map.remove(c2);
                }
            }
            max = Math.max(max, i-start+1);
        }
        return max;
    }
}