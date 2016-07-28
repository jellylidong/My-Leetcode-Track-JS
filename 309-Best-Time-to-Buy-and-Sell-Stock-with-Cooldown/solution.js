/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    // //dp[i][0,1,2]
    // //profit of day i, 0:buy, 1:sell, 2:rest
    // //problem is we can not make sure that we sell a stock after we already buy one
    
    // var dp = [];
    // var len = prices.length;
    // if(len === 0)   return 0;
    // for(let i = 0; i < len; i++) dp[i] = [];
    
    // dp[0][0] = -prices[0];
    // dp[0][1] = 0;
    // dp[0][2] = 0;
    
    // for(let i = 1; i < len; i++){
    //     dp[i][0] = dp[i-1][2] - prices[i];
    //     dp[i][1] = dp[i-1][2] + prices[i];
    //     dp[i][2] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
    // }
    // console.log(dp);
    // return Math.max(dp[len-1][0], Math.max(dp[len-1][1], dp[len-1][2]));
    
    //X[i] means we may do X action at day i
    //the action will only happen when doning so make more profit
    var buy = [], sell = [], rest = [];
    var len = prices.length;
    if(len === 0)   return 0;
    buy[0] = - prices[0];
    sell[0] = 0;
    rest[0] = 0;
    
    for(let i = 1; i < len; i++){
        buy[i] = Math.max(rest[i-1]-prices[i], buy[i-1]);
        
        //note the sell here, we should not consider rest, 
        //because rest[i-1] can not guarantee that we already bought a stock
        //we cant sell a stock without buying it
        sell[i] = Math.max(buy[i-1]+prices[i], sell[i-1]);
        rest[i] = Math.max(buy[i-1], Math.max(sell[i-1], rest[i-1]));
    }
    
    return Math.max(buy[len-1], Math.max(rest[len-1], sell[len-1]));
};