public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length <= 2)    return false;
        int minId = findMinId(nums, 0, 0);
        int maxId = findMaxId(nums, 2, nums.length-1);
        
        for(int i = 1; i <= nums.length-2; i++){
            if(i == maxId) maxId = findMaxId(nums, maxId+1, nums.length-1);
            if(nums[minId] < nums[i] && nums[i] < nums[maxId])  return true;
            if(nums[i] < nums[minId])   minId = i;
            
        }
        
        return false;
    }
    
    public int findMinId(int[] nums, int lo, int hi){
        int minId = lo;
        for(int i = lo+1; i <= hi; i++){
            if(nums[i] < nums[minId])
                minId = i;
        }
        return minId;
    }
    
    public int findMaxId(int[] nums, int lo, int hi){
        int maxId = lo;
        for(int i = lo+1; i <= hi; i++){
            if(nums[i] >= nums[maxId])
                maxId = i;
        }
        return maxId;
    }
}