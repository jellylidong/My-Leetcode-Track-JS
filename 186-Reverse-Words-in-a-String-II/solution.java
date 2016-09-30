public class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);
        int lo = 0;
        int hi = 0;
        for(; hi < s.length; hi++){
            if(s[hi] == ' '){
                reverse(s, lo, hi-1);
                lo = hi+1;
            }
        }
        reverse(s, lo, hi-1);
        
    }
    
    public void reverse(char[] s, int lo, int hi){
        while(lo < hi){
            char tmp = s[lo];
            s[lo] = s[hi];
            s[hi] = tmp;
            lo++;
            hi--;
        }
    }
}