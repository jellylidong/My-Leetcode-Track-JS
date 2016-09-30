public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length == 0)    return ans;
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++){
            int lo = i+1;
            int hi = nums.length-1;
            
            while(lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                if(sum > 0) hi--;
                else if(sum < 0) lo++;
                else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[lo]);
                    list.add(nums[hi]);
                    ans.add(list);
                    lo++;
                    hi--;
                    while(lo > i+1 && lo < hi && nums[lo] == nums[lo-1]) lo++;
                    while(hi < nums.length-1 && lo < hi && nums[hi] == nums[hi+1]) hi--;
                }
            }
            
            while(i+1 < nums.length && nums[i] == nums[i+1]) i++;
        }
        return ans;
        
    }
}