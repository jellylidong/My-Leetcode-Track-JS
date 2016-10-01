public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        if(nums.length < 2) return ans;
        
        int lo = 0;
        int hi = nums.length-1;
        while(lo < hi){
            if(nums[lo] + nums[hi] < target)    lo++;
            else if(nums[lo] + nums[hi] > target) hi--;
            else{
                ans[0] = lo+1;
                ans[1] = hi+1;
                break;
            }
        }
        
        return ans;
    }
}