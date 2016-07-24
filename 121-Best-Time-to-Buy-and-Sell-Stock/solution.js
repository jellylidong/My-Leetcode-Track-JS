/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    // //method 1 DP
    // if(prices.length === 0) return 0;
    // //min[i] is the min value of prices[0..i]
    // //max[i] is the max value of prices[i..len-1]
    // var len = prices.length;
    // var max = []; max.push(prices[len-1])
    // var min = []; min.push(prices[0]);
    // for(let i = 1; i < len; i++)
    //     max.unshift(Math.max(max[0], prices[len-1-i]));
    // for(let i = 1; i < len; i++)
    //     min.push(Math.min(min[i-1], prices[i]));
    // var ans = 0;
    // for(let i = 0; i < len; i++)
    //     ans = Math.max(ans, max[i]-min[i]);
    // return ans;
    
    //method 2 optimize based on method 1, non-DP
    var len = prices.length;
    if(len === 0)   return 0;
    var ans = 0;
    var min = prices[0];
    for(let i = 1; i < len; i++){
        if(prices[i] < min)
            min = prices[i];
        else
            ans = Math.max(prices[i]-min, ans);
    }
    return ans;
    
};