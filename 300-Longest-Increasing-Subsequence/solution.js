/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function(nums) {
    //O(N^2)
    //for any i < j, if nums[i] < nums[j]
    //LIS end with nums[j] is max(LIS[i]+1, LIS[j])
    // var LIS = [];
    // for(let i = 0; i < nums.length; i++)
    //     LIS[i] = 1;
    // for(let hi = 0; hi < nums.length; hi++){
    //     for(let lo = 0; lo < hi; lo++){
    //         if(nums[lo] < nums[hi])
    //             LIS[hi] = Math.max(LIS[lo]+1, LIS[hi]);
    //     }
    // }
    // var max = 0;
    // for(let i = 0; i < nums.length; i++)
    //     max = Math.max(max, LIS[i]);
    // return max;
    
    //O(NlogN)
    //use a binary search helper, return the index if found
    //return the insert position of not found
    var binarySearch = function(arr, lo, hi, target){
        if(arr.length === 0)    return 0;
        while(lo < hi){
            var mid = lo + Math.floor((hi-lo)/2);
            if(arr[mid] === target) return mid;
            if(arr[mid] < target)   lo = mid+1;
            else    hi = mid-1;
        }
        if(arr[lo] === target)  return lo
        else{
            if(target < arr[lo])    return lo;
            else    return (lo+1);
        }
    }
    
    var dp = [];
    nums.forEach(function(n){
        var index = binarySearch(dp, 0, dp.length-1, n);
        dp[index] = n;
    });
    return dp.length;
};