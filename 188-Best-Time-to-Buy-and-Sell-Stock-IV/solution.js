/**
 * @param {number} k
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(k, prices) {
    var ans = 0;
    if(k >= Math.floor(prices.length/2)){
        for(let i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1])
                ans += prices[i] - prices[i-1];
        }
        return ans;
    }
    else{
        var dp = [];
        //dp[k][d] mean the max profit with up to k transactions and up to day d
        for(let i = 0; i <= k; i++){
            dp[i] = [];
            for(let j = 0; j < prices.length; j++)
                dp[i][j] = 0;
        }
        
        
        for(let i = 1; i <= k; i++){
            var tmpMax = dp[i-1][0] - prices[0];
            for(let j = 1; j < prices.length; j++){
                dp[i][j] = Math.max(dp[i][j-1], tmpMax+prices[j]);
                tmpMax = Math.max(tmpMax, dp[i-1][j]-prices[j]);
                ans = Math.max(ans, dp[i][j]);
            }
        }
    }
    return ans;
};