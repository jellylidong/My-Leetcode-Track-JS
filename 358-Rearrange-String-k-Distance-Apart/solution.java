public class Solution {
    public String rearrangeString(String str, int k) {
        int[] count = new int[26];
        int[] position = new int[26];
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            count[c-'a']++;
        }
        
        String res = helper(count, position, k, str.length());
        
        return res.length() == str.length()? res:"";
    }
    
    public String helper(int[] count, int[] position, int k, int len){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            int index = -1;
            int max = 0;
            for(int j = 0; j < count.length; j++){
                if(count[j] > 0 && count[j] > max && i >= position[j]){
                    max = count[j];
                    index = j;
                }
            }
            if(index == -1) return sb.toString();
            count[index]--;
            position[index] = i+k;
            sb.append((char)('a'+index));
        }
        return sb.toString();
    }
}