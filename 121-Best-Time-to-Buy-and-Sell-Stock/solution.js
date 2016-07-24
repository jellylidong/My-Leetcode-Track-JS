/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    //method 1
    if(prices.length === 0) return 0;
    //min[i] is the min value of prices[0..i]
    //max[i] is the max value of prices[i..len-1]
    var len = prices.length;
    var max = []; max.push(prices[len-1])
    var min = []; min.push(prices[0]);
    for(let i = 1; i < len; i++)
        max.unshift(Math.max(max[0], prices[len-1-i]));
    for(let i = 1; i < len; i++)
        min.push(Math.min(min[i-1], prices[i]));
        
    // console.log(max);
    // console.log(min);
    var ans = 0;
    for(let i = 0; i < len; i++)
        ans = Math.max(ans, max[i]-min[i]);
    return ans;
    
};