/**
 * @param {number} n
 * @return {number}
 */
var nthUglyNumber = function(n) {
    var dp = [1, 1];
    var i2 = 1, i3 = 1, i5 = 1;
    for(let i = 2; i <= n; i++){
        var n2 = dp[i2]*2, n3 = dp[i3]*3, n5 = dp[i5]*5;
        dp[i] = Math.min(n2, Math.min(n3, n5));
        if(n2 <= dp[i])   i2++;
        if(n3 <= dp[i])   i3++;
        if(n5 <= dp[i])   i5++;
    }
    // console.log(dp);
    return dp[n];
};