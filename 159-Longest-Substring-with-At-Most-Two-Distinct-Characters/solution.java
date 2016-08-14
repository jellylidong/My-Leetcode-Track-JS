public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        
        int s = 0;
        int e = 0;
        for(; e < str.length(); e++){
            char c = str.charAt(e);
            map.put(c, e);
            if(map.size() > 2){
                char minKey = 'a';
                int minValue = Integer.MAX_VALUE;
                for(Map.Entry<Character, Integer> entry: map.entrySet()){
                    if(minValue > entry.getValue()){
                        minValue = entry.getValue();
                        minKey = entry.getKey();
                    }
                }
                s = minValue+1;
                map.remove(minKey);
            }
            
            max = Math.max(max, e-s+1);
        }
        
        return max;
    }
}