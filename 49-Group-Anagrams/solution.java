public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        
        for(String s: strs){
            String code = encode(s);
            if(!map.containsKey(code))  map.put(code, new ArrayList<String>());
            map.get(code).add(s);
        }
        
        ans.addAll(map.values());
        return ans;
    }
    
    public String encode(String s){
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            count[c-'a']++;
        }
        for(int i = 0; i < 26; i++){
            sb.append(i+'a');
            sb.append(count[i]);
        }
        
        return sb.toString();
    }
}