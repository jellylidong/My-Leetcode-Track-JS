/**
 * @param {string} s
 * @param {string} t
 * @return {number}
 */
var numDistinct = function(s, t) {
    /*my analysis
    * res[j][i] mean the number of sub-sequences of T.substring(0, i) in S.substring(0, j)
    * for res[j][0], there's only one solution, that is to delete all char in T
    *
    * for other res[j][i],
    * case 1: S.charAt(j-1) != T.charAt(i-1)
    * what we need to do is to ignore the S.charAT(j-1)
    * so res[j][i] = 1 * res[j-1][i]
    *
    * case 2: S.charAt(j-1) == T.charAt(i-1)
    * we can also ignore S.charAt(j-1) like case 1,
    * so part of res[j][i] would be res[j-1][i]
    * we can also ignore both S.charAt(j-1) and T.charAt(i-1) because they are the same
    * so the other part wound be res[j-1][i-1]
    * so res[j][i] = res[j-1][i] + res[j-1][i-1]
    * */
    
    var ls = s.length;
    var lt = t.length;
    
    if(ls === 0 && lt !== 0) return 0;
    
    var dp = [];
    for(let i = 0; i <= ls; i++){
        dp[i] = [];
        for(let j = 0; j <= lt; j++)
            dp[i][j] = 0;
    }
    
    dp[0][0] = 1;
    for(let i = 1; i <= ls; i++)
        dp[i][0] = 1;
    // for(let i = 1; i <= lt; i++)
    //     dp[0][i] = 0;
        
    for(let i = 1; i <= ls; i++){
        for(let j = 1; j <= lt; j++){
            if(s[i-1] !== t[j-1])
                dp[i][j] = dp[i-1][j];
            else
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
        }
    }
    
    return dp[ls][lt];
};