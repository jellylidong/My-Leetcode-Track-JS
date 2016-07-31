public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        //dp[i][j] means the max cost of guessing a number in range [i, j], both inclusive
        return helper(1, n, dp);
        
    }
    
    public int helper(int lo, int hi, int[][] dp){
        if(lo >= hi)    return 0; //only one number or invalid range
        if(dp[lo][hi] != 0)
            return dp[lo][hi];
            
        //for range [lo, hi],
        //the max cost is we guess start from i,
        //case 1: the target number is in range [lo, i-1], 
        //case 2: the target number is in range [i+1, hi];
        //we chooe the max value of the two cases
        int ans = Integer.MAX_VALUE;
        for(int i = lo; i <= hi; i++){
            int cur = i + Math.max(helper(lo, i-1, dp), helper(i+1, hi, dp));
            ans = Math.min(ans, cur);
        }
        dp[lo][hi] = ans;
        return ans;
    }
}