/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var combinationSum4 = function(nums, target) {
    var map = new Map();
    
    var helper = function(nums, target){
        if(target < 0) return 0;
        if(target === 0)    return 1;
        if(map.has(target))
            return map.get(target);
        var ans = 0;
        for(let i = 0; i < nums.length; i++){
            ans += helper(nums, target-nums[i]);
        }
        map.set(target, ans);
        return ans;
    }
    
    return helper(nums, target);
};