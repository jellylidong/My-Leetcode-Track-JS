/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var combinationSum4 = function(nums, target) {
    //method 1: top-down DP
    // var map = new Map();
    // var helper = function(nums, target){
    //     if(target < 0) return 0;
    //     if(target === 0)    return 1;
    //     if(map.has(target))
    //         return map.get(target);
    //     var ans = 0;
    //     for(let i = 0; i < nums.length; i++){
    //         ans += helper(nums, target-nums[i]);
    //     }
    //     map.set(target, ans);
    //     return ans;
    // }
    // return helper(nums, target);
    
    //method 2: bottom-up DP
    var dp = [];
    for(let i = 0; i <= target; i++)
        dp.push(0);
    dp[0] = 1;
    for(let i = 1; i <= target; i++){
        for(let j = 0;  j < nums.length; j++){
            if(i - nums[j] >= 0)
                dp[i] += dp[i - nums[j]];
        }
    }
    return dp[target];
};