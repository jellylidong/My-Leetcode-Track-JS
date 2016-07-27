/**
 * @param {string} s1
 * @param {string} s2
 * @param {string} s3
 * @return {boolean}
 */
var isInterleave = function(s1, s2, s3) {
    var l1 = s1.length;
    var l2 = s2.length;
    
    if(l1+l2 !== s3.length)
        return false;
        
    var dp = [];
    for(let i = 0; i <= l1; i++){
        dp[i] = [];
        for(let j = 0; j <= l2; j++){
            dp[i][j] = false;
        }
    }
    
    dp[0][0] = true;
    for(let i = 1; i <= l1; i++)
        dp[i][0] = dp[i-1][0] && s1[i-1] == s3[i-1];
    for(let i = 1; i <= l2; i++)
        dp[0][i] = dp[0][i-1] && s2[i-1] == s3[i-1];
        
    for(let i = 1; i <= l1; i++){
        for(let j = 1; j <= l2; j++){
            dp[i][j] = (s1[i-1] == s3[i+j-1] && dp[i-1][j]) ||
                       (s2[j-1] == s3[i+j-1] && dp[i][j-1]);
        }
    }
    return dp[l1][l2];
};