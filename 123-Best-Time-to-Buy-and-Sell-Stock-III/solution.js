/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    var len = prices.length;
    if(len <= 1)    return 0;
    var dp = []; //dp[i][j] means max profit up to day i transactions and day j, both inclusive
    var ans = 0;
    var k = 2;
    for(let i = 0; i <= k; i++){
        dp[i] = [];
        for(let j = 0; j < len; j++)
            dp[i][j] = 0;
    }

    for(let i = 1; i <= k; i++){
        let tmpMax = dp[i-1][0] - prices[0];
        for(let j = 1; j < len; j++){
            dp[i][j] = Math.max(dp[i][j-1], tmpMax + prices[j]);
            tmpMax = Math.max(tmpMax, dp[i-1][j] - prices[j]);
            ans = Math.max(dp[i][j], ans);
            
            // f[kk][ii] = max(f[kk][ii-1], prices[ii] + tmpMax);
            // tmpMax = max(tmpMax, f[kk-1][ii] - prices[ii]);
            // maxProf = max(f[kk][ii], maxProf);
            
        }
    }
    // console.log(dp)
    return ans;
};