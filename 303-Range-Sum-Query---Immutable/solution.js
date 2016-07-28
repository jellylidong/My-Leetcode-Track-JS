/**
 * @constructor
 * @param {number[]} nums
 */
 
var sum = []
var NumArray = function(nums) {
    sum[0] = nums[0];
    for(let i = 1; i < nums.length; i++){
        sum[i] = sum[i-1] + nums[i];
    }
};

/**
 * @param {number} i
 * @param {number} j
 * @return {number}
 */
NumArray.prototype.sumRange = function(i, j) {
    if(i === 0)
        return sum[j];
    return sum[j] - sum[i-1];
};


/**
 * Your NumArray object will be instantiated and called as such:
 * var numArray = new NumArray(nums);
 * numArray.sumRange(0, 1);
 * numArray.sumRange(0, 2);
 */