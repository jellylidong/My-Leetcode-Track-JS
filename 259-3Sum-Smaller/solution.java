public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int ans = 0;
        if(nums.length < 3) return 0;
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                for(int k = nums.length-1; k > j; k--){
                    if(nums[i] + nums[j] + nums[k] < target){
                        ans += (k-j);
                        break;
                    }
                }
            }
        }
        
        return ans;
    }
}