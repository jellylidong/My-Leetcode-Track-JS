/**
 * @param {number} n
 * @return {number}
 */
var numSquares = function(n) {
    
    //this method got stack overflow when the number is too big
    // var map = new Map();
    // var helper = function(n){
    //     if(n === 0)  return 0;
    //     if(n <= 2)  return n;
    //     if(map.has(n))  return map.get(n);
        
    //     var min = Number.MAX_VALUE;
    //     for(let i = 1; i <= Math.floor(n/2); i++){
    //         if(i*i <= n){
    //             min = Math.min(min, 1+helper(n-i*i));
    //         }
    //     }
    //     map.set(n, min);
    //     return min;
    // }
    
    // return helper(n);
    
    
    //method 2 DP
    // var dp = [];
    // for(let i = 0; i <= n; i++)
    //     dp.push(Number.MAX_VALUE);
    // dp[0] = 0;
    // for(let i = 0; i <= n; i++){
    //     for(let j = 1; i+j*j <= n; j++){
    //         dp[i+j*j] = Math.min(dp[i+j*j], 1+dp[i]);
    //     }
    // }
    // return dp[n];
    
    
    //method 3 BFS
    var sqrSet = [];
    var count = new Map();
    for(let i = 0; i*i <= n; i++){
        sqrSet.push(i*i);
        count.set(i*i, 1);
    }
    if(count.has(n))    return 1;
    var q = [];
    sqrSet.forEach(function(value){q.push(value)});
    var curCount = 1;
    while(q.length > 0){
        curCount++;
        var len = q.length;
        for(let i = 0; i < len; i++){
            var num = q.shift();
            
            for(let j = 0; j < sqrSet.length; j++){
                var value = sqrSet[j];
                if(num + value === n)   return curCount;
                else if(num+value < n && !count.has(num+value)){
                    count.set(num+value, curCount);
                    q.push(num+value);
                }
                else if(num+value > n){  break;}
            }
        }
    }
    return 0;
};