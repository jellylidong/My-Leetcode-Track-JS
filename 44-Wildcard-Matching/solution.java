public class Solution {
    public boolean isMatch(String s, String p) {
        
        int lo = 0;
        while(lo < p.length() && p.charAt(lo) == '*'){
            lo++;
        }
        if(lo > 0)  lo--;
        
        int hi = p.length()-1;
        while(lo < hi && p.charAt(hi) == '*'){
            hi--;
        }
        if(hi < p.length()-1) hi++;
        
        p = p.substring(lo, hi+1);
        
        int ls = s.length();
        int lp = p.length();
        boolean[][] dp = new boolean[ls+1][lp+1]; // s.substring(i, ls) matches p.substring(j, lp)
        dp[ls][lp] = true; //empty matches empty
        
        //!!!!!!!!
        if(lp-1 >= 0)
            dp[ls][lp-1] = p.charAt(lp-1) =='*';//for case s = "aa", p = "*"
            
             
        for(int i = ls-1; i >= 0; i--){
            for(int j = lp-1; j >= 0; j--){
                if(s.charAt(i) == p.charAt(j))
                    dp[i][j] = dp[i+1][j+1];
                else if(p.charAt(j) == '?')
                     dp[i][j] = dp[i+1][j+1];
                else if(p.charAt(j) == '*')
                    dp[i][j] = dp[i+1][j] || dp[i][j+1];
                    // * already matches a string, s.charAt(i) just adds a char to the string|| * works as empty
            }
        }
        
        return dp[0][0];
        
        
    }
}