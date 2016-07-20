/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function(s, p) {
    var ls = s.length;
    var lp = p.length;
    
    //dp[i][j] means s.substring(0, i) matches p.substring(0, j)
    var dp = []; 
    for(let i = 0; i < ls+1; i++){
        dp.push([]);
        for(let j = 0; j < lp+1; j++)
            dp[i].push(false);
    }
    
    dp[0][0] = true;//empty matches empty
    for(let i = 1; i <= lp; i++){
        // p.substirng(0, 1) is impossible to match empty str, or it's because i>1 can make sure i-2 is valid
        dp[0][i] = i > 1 && p[i-1] === '*' && dp[0][i-2];
    }
    //non empty can not match empty (not necessary because already initialized with false)
    //for(let i = 1; i <= ls; i++)    dp[i][0] = false;
    
    for(let i = 1; i <= ls; i++){
        for(let j = 1; j <= lp; j++){
            if(p[j-1] == '.' || p[j-1] == s[i-1])
                dp[i][j] = dp[i-1][j-1];
            else if(p[j-1] == '*'){
                dp[i][j] = // '*'' combines with previous char, stands for 0 char, ie X* is empty str
                           dp[i][j-2] || 
                        //   for example		
                        //   s = ####X		
                        //   p = ########*		
                        //   dp[i-1][j] means #### matches ########*		
                        //   if ####x also matches ########*, ########* can only be #######.* or #######X*
                        // is '*' works as one previous char
                           (dp[i-1][j] && (p[j-1-1] === '.' || p[j-1-1] == s[i-1]));
            }
        }
    }
    return dp[ls][lp];
};