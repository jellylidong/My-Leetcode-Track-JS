/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
    var helper = function(arr1, lo1, hi1, arr2, lo2, hi2, k){
        //for recursion,
        //pay attention to the return condition (end recursion condition)
        //this function is used to find kth number from two sorted array
        //!!!!!note k is count from 0
        
        if(lo1 > hi1)   return arr2[lo2+k];
        if(lo2 > hi2)   return arr1[lo1+k];
        
        var m1 = lo1 + Math.floor((hi1-lo1)/2);
        var m2 = lo2 + Math.floor((hi2-lo2)/2);
        
        if(arr1[m1] < arr2[m2]){
            //!!!!!note k is count from 0
            //so here k should be 'k <', not 'k <='
            if(k < (m1-lo1+1) + (m2-lo2))
                return helper(arr1, lo1, hi1, arr2, lo2, m2-1, k);
            else
                return helper(arr1, m1+1, hi1, arr2, lo2, hi2, k-(m1-lo1+1));
        }
        else{
            if(k < (m2-lo2+1) + (m1-lo1))
                return helper(arr2, lo2, hi2, arr1, lo1, m1-1, k);
            else
                return helper(arr2, m2+1, hi2, arr1, lo1, hi1, k-(m2-lo2+1));
        }
    }
    
    var l1 = nums1.length;
    var l2 = nums2.length;
    var ans1 = helper(nums1, 0, l1-1, nums2, 0, l2-1, Math.floor((l1+l2)/2));
    if((l1+l2)%2 === 0){
        var ans2 = helper(nums1, 0, l1-1, nums2, 0, l2-1, Math.floor((l1+l2)/2)-1);
        ans1 = (ans1 + ans2)/2;
    }
    
    return ans1;
    
};