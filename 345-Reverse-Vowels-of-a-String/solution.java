public class Solution {
    public String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        int lo = 0;
        int hi = s.length()-1;
        
        while(lo < hi){
            while(lo < hi && !isV(cs[lo]))
                lo++;
            while(lo < hi && !isV(cs[hi]))
                hi--;
            if(lo < hi){    
                char tmp = cs[lo];
                cs[lo] = cs[hi];
                cs[hi] = tmp;
                lo++;
                hi--;
            }
        }
        
        return new String(cs);
    }
    
    public boolean isV(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}