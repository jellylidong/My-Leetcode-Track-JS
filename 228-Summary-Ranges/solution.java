public class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> ans = new ArrayList<>();
        
        int i = 0;
        while(i < nums.length){
            int j = i+1;
            while(j < nums.length && nums[j] == nums[j-1]+1)
                j++;
            
            String s = "";
            if(nums[i] == nums[j-1])
                s += nums[i];
            else
                s += nums[i] + "->" + nums[j-1];
                
            ans.add(s);
            i = j;
        }
        
        return ans;
    }
}