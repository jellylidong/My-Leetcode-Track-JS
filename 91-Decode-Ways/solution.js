/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function(s) {
    var len = s.length;
    if(len === 0)   return 0;
    var dp = [];
    for(let i = 0; i <= len; i++){
        dp.push(0);
    }
    dp[len] = 1;
    dp[len-1] = s[len-1] == '0'? 0:1;
    
    for(let i = len-2; i >= 0; i--){
        if(s[i] == '0') dp[i] = 0;
        else{
            dp[i] += dp[i+1];
            let cur = s.substring(i, i+2).valueOf();
            if(cur > 0 && cur <= 26)    dp[i] += dp[i+2];
        }
    }
    
    return dp[0];
};