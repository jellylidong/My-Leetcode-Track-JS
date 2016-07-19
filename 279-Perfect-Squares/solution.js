/**
 * @param {number} n
 * @return {number}
 */
var numSquares = function(n) {
    
    //this method got stack overflow when the number is too big
    // var map = new Map();
    // var helper = function(n){
    //     if(n === 0)  return 0;
    //     if(n <= 2)  return n;
    //     if(map.has(n))  return map.get(n);
        
    //     var min = Number.MAX_VALUE;
    //     for(let i = 1; i <= Math.floor(n/2); i++){
    //         if(i*i <= n){
    //             min = Math.min(min, 1+helper(n-i*i));
    //         }
    //     }
    //     map.set(n, min);
    //     return min;
    // }
    
    // return helper(n);
    
    var dp = [];
    for(let i = 0; i <= n; i++)
        dp.push(Number.MAX_VALUE);
    dp[0] = 0;
    for(let i = 0; i <= n; i++){
        for(let j = 1; i+j*j <= n; j++){
            dp[i+j*j] = Math.min(dp[i+j*j], 1+dp[i]);
        }
    }
    return dp[n];
};