public class Solution {
    int left, right; //both exclusive
    public String longestPalindrome(String s) {
        left = -1;
        right = 0;
        for(int i = 0; i < s.length(); i++){
            extend(s, i, i);
            extend(s, i, i+1);
        }
        return s.substring(left+1, right);
    }
    
    public void extend(String s, int lo, int hi){
        while(lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)){
            lo--;
            hi++;
        }
        if(hi-lo > right-left){
            this.left = lo;
            this.right = hi;
        }
    }
}