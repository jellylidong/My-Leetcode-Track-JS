/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    var helper = function(nums, lo, hi){
        var dp = [];
        for(let i = 0; i <= hi-lo; i++){
            dp[i] = [];
            dp[i][0] = 0; //not rob i
            dp[i][1] = 0; //rob i
        }

        dp[0][0] = 0;
        dp[0][1] = nums[lo];
        for(let i = 1; i <= hi-lo; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = nums[i+lo] + dp[i-1][0];
        }
        console.log(dp)
        return Math.max(dp[hi-lo][0], dp[hi-lo][1]);
    }
    var len = nums.length;
    if(len === 0)   return 0;
    if(len === 1)   return nums[0];
    return Math.max(helper(nums, 0, len-2), helper(nums, 1, len-1));
};