/**
 * @param {number} n
 * @return {number}
 */
var nthUglyNumber = function(n) {
    var dp = [1, 1];
    var i2 = 1, i3 = 1, i5 = 1;
    for(let i = 2; i <= n; i++){
        dp[i] = Math.min(dp[i2]*2, Math.min(dp[i3]*3, dp[i5]*5));
        if(dp[i2]*2 <= dp[i])   i2++;
        if(dp[i3]*3 <= dp[i])   i3++;
        if(dp[i5]*5 <= dp[i])   i5++;
    }
    // console.log(dp);
    return dp[n];
};