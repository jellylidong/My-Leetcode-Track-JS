/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function(nums) {
    //O(N^2)
    //for any i < j, if nums[i] < nums[j]
    //LIS end with nums[j] is max(LIS[i]+1, LIS[j])
    var LIS = [];
    for(let i = 0; i < nums.length; i++)
        LIS[i] = 1;
    for(let hi = 0; hi < nums.length; hi++){
        for(let lo = 0; lo < hi; lo++){
            if(nums[lo] < nums[hi])
                LIS[hi] = Math.max(LIS[lo]+1, LIS[hi]);
        }
    }
    var max = 0;
    for(let i = 0; i < nums.length; i++)
        max = Math.max(max, LIS[i]);
    return max;
};