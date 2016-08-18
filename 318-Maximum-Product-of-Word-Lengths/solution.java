public class Solution {
    public int maxProduct(String[] words) {
        int[] bits = new int[words.length];
        for(int i = 0; i < words.length; i++){
            String cur = words[i];
            for(int j = 0; j < cur.length(); j++){
                bits[i] |= (1<<(cur.charAt(j)-'a'));
            }
        }
        
        int max = 0;
        for(int i= 0; i < words.length; i++){
            for(int j = i+1; j < words.length; j++){
                if((bits[i]&bits[j]) == 0)
                    max = Math.max(max, words[i].length()*words[j].length());
            }
        }
        
        return max;
    }
}