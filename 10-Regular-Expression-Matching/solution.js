/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function(s, p) {
    var ls = s.length;
    var lp = p.length;
    
    var dp = [];
    for(let i = 0; i <= ls; i++){
        dp[i] = [];
        for(let j = 0; j <= lp; j++)
            dp[i][j] = false;
    }
    // console.log(dp)
    dp[0][0] = true;
    for(let i = 1; i <= ls; i++)
        dp[i][0] = false;
    for(let i = 1; i <= lp; i++)
        dp[0][i] = i > 1 && dp[0][i-2] && p[i-1] === '*';
        
    for(let i = 1; i <= ls; i++){
        for(let j = 1; j <= lp; j++){
            if(p[j-1] === '.' || p[j-1] == s[i-1])
                dp[i][j] = dp[i-1][j-1];
            else if(p[j-1] === '*')
                dp[i][j] = dp[i][j-2] || (dp[i-1][j] && (p[j-2] === '.' || p[j-2] == s[i-1]));
        }
    }
    // console.log(dp)
    return dp[ls][lp];
};