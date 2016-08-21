public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        for(; i < nums.length; i++){
            while(i+1 < nums.length && nums[i] == nums[i+1])
                i++;
            nums[j] = nums[i];
            j++;
        }
        return j;
    }
}