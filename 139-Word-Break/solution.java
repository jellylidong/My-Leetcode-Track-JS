public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int[] dp = new int[s.length()+1]; //0: unvisited, 1: splitable, -1:unsplitable
        dp[s.length()] = 1;
        return helper(s, wordDict, 0, dp);
    }
    
    public boolean helper(String s, Set<String> dict, int start, int[] dp){
        if(dp[start] != 0)  return dp[start] == 1;
        boolean res = false;
        for(int i = start+1; i <= s.length(); i++){
            res = dict.contains(s.substring(start, i)) && helper(s, dict, i, dp);
            if(res == true) break;
        }
        dp[start] = res? 1:-1;
        return res;
    }
}