public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0)    return new int[0];
        int[] ans = new int[nums.length - k+1];
        
        int maxIndex = 0;
        int max = nums[0];
        for(int i = 0; i <= k-1; i++){
            if(nums[i] >= max){
                max = nums[i];
                maxIndex = i;
            }
        }
        ans[0] = max;
        for(int i = 1; i <= nums.length-k; i++){
            if(maxIndex >= i && maxIndex <= i+k-1){
                if(nums[i+k-1] >= max){
                    max = nums[i+k-1];
                    maxIndex = i+k-1;
                }
                ans[i] = max;
            }
            else{
                max = nums[i];
                maxIndex = i;
                for(int j = i; j <= i+k-1; j++){
                    if(nums[j] >= max){
                        max = nums[j];
                        maxIndex = j;
                    }
                }
                ans[i] = max;
            }
        }
        
        return ans;
    }
}