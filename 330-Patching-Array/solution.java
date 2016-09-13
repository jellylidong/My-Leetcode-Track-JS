public class Solution {
    public int minPatches(int[] nums, int n) {
        int i = 0; //beginning index
        long miss = 1; //current upper bound
        int count = 0; //count of number patched
        
        // if(nums.length == 0) //for corner case no number is is given
        //         nums = new int[] {n};

        while(miss <= n){
            if(i == nums.length || (i < nums.length && nums[i] > miss)){
                //we want to reach nums[i], but we currently we only reach miss-1
                //so we should patch miss to extend to the largest upper bound
                //after patching, we can reach miss-1+miss
                //so the upper bound should be miss += miss
                miss += miss;
                count++; 
            }
            else if(i < nums.length && nums[i] <= miss){
                //we want to reach nums[i], but we already reach miss-1
                //so we can actually reach nums[i]+miss-1
                //so the upper bound should be nums[i]+miss
                miss += nums[i];
                i++;
            }
        }
        return count;
}
}