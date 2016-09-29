public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0)    return new int[0];
        int maxIdx = -1;
        int maxVal = Integer.MIN_VALUE;
        
        
        int[] ans = new int[nums.length-k+1];
        ans[0] = maxVal;
        
        for(int i = 0; i <= nums.length-k; i++){
        	if(maxIdx < i){
        	    maxVal = Integer.MIN_VALUE;
        		for(int j = i; j < i+k; j++){
                	if(nums[j] >= maxVal){
                		maxVal = nums[j];
                		maxIdx = j;
                	}
                }
        	}
        	else if(nums[i+k-1] >= maxVal){
        		maxVal = nums[i+k-1];
        		maxIdx = i+k-1;
        	}
        	ans[i] = maxVal;
        }
        
        return ans;
    }
}