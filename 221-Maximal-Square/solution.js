/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalSquare = function(matrix) {
    var max = 0;
    var m = matrix.length;
    if(m === 0) return 0;
    var n = matrix[0].length;
    if(n === 0) return 0;
    var dp = [];
    for(let i = 0; i <= m; i++){
        dp[i] = [];
        for(let j = 0; j <= n; j++)
            dp[i][j] = 0;
    }
    for(let i = 1; i <= m; i++){
        for(let j = 1; j <= n; j++){
            if(matrix[i-1][j-1] == 1){
                dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                max = Math.max(max, dp[i][j]);
            }
        }
    }
    
    return max*max;
};