public class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)) map.put(c, 0);
            map.put(c, map.get(c)+1);
        }
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(!map.containsKey(c)) return c;
            map.put(c, map.get(c)-1);
            if(map.get(c) == 0) map.remove(c);
        }
        
        return '0';
        
    }
}