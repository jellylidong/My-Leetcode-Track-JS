/**
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */
var minDistance = function(word1, word2) {
    var l1 = word1.length;
    var l2 = word2.length;
    var dp = [];
    for(let i = 0; i <= l1; i++){
        dp.push([]);
        for(let j = 0; j <= l2; j++){
            dp[i].push(0);
        }
    }
    for(let i = 1; i <= l2; i++)
        dp[0][i] = i;
    for(let i = 1; i <= l1; i++)
        dp[i][0] = i;
        
    for(let i = 1; i <= l1; i++){
        for(let j = 1; j <= l2; j++){
            let Insert = 1 + dp[i-1][j];
            let Delete = 1 + dp[i][j-1];
            let Replace = dp[i-1][j-1] + (word1[i-1] == word2[j-1]? 0:1);
            dp[i][j] = Math.min(Insert, Math.min(Delete, Replace));
        }
    }
    return dp[l1][l2];
};