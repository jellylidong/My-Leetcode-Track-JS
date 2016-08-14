public class Solution {
    public int findPeakElement(int[] nums) {
        // if(nums.length == 1)    return 0;
        // if(nums[0] > nums[1])   return 0;
        // if(nums[nums.length-1] > nums[nums.length-2])   return nums.length-1;
        
        // for(int i = 1; i < nums.length-1; i++){
        //     if(nums[i-1] < nums[i] && nums[i] > nums[i+1])
        //         return i;
        // }
        
        // return -1;
        
        //each local max is peak, 
        //so we just go to the part that has a bigger value to find a peak
        int lo = 0;
        int hi = nums.length-1;
        while(lo < hi){
            int m1 = lo + (hi-lo)/2;
            int m2 = m1+1;
            
            if(nums[m1] > nums[m2]) hi = m1;
            else    lo = m2;
        }
        
        return lo;
    }
}