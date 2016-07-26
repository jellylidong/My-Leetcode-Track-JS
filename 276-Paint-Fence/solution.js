/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
var numWays = function(n, k) {
    if(n === 0 || k === 0)  return 0;
    if(n === 1) return k;
    
    var preSame = k; //paint first 2 with same color
    var preDiff = k*(k-1); // paint first 2 with diff color
    
    for(let i = 3; i <= n; i++){
        var nextSame = preDiff;
        var nextDiff = (preSame + preDiff) * (k-1);
        preSame = nextSame;
        preDiff = nextDiff;
    }
    
    return preSame + preDiff;
};