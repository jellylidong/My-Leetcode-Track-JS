public class Solution {
    public int minPatches(int[] nums, int n) {
        int i = 0;
        long miss = 1; 
        //exclusive bound, miss is the upper bound that nums[0...i] can not reach, i is exclusive
        //note: the upper bound can bigger than int_max, so we use long
        int count = 0;
        
        // while(miss <= n){
        //     if(i < nums.length && nums[i] <= miss){
        //         miss += nums[i];
        //         i++; //
        //     }
        //     else{
        //         miss += miss;
        //         count++;
        //     }
        // }
        
        // return count;
        
        while(miss <= n){
            if(i == nums.length || (i < nums.length && nums[i] > miss)){
                //target is nums[i], but we can only reach miss-1
                //so we shuold patch miss, 
                //then the the upper bound we can not reach becuomes miss+miss
                //so:
                miss += miss;
                count++;
            }
            else if(i < nums.length && nums[i] <= miss){
                //nums[i] <= miss
                //we reached nums[i]
                //but we can already reach miss-1,
                //so the real upper bould shuold be miss+nums[i];
                miss += nums[i];
                i++;
            }
            
        }
        
        return count;
    }
}