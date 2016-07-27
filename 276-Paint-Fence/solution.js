/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
var numWays = function(n, k) {
    if(n === 0 || k === 0)
        return 0;
    if(n === 1)
        return k;
        
    var same = k;
    var diff = k*(k-1);
    
    for(let i = 3; i <= n; i++){
        var nextSame = diff;
        var nextDiff = (same + diff)*(k-1);
        same = nextSame;
        diff = nextDiff;
    }
    
    return same + diff;
};