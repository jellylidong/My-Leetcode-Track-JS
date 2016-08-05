public class Solution {
    public void wiggleSort(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            if(i%2 == 1){
                if(nums[i] < nums[i-1]){
                    int tmp = nums[i];
                    nums[i] = nums[i-1];
                    nums[i-1] = tmp;
                }
            }
            if(i%2 == 0){
                if(nums[i] > nums[i-1]){
                    int tmp = nums[i];
                    nums[i] = nums[i-1];
                    nums[i-1] = tmp;
                }
            }
        }
    }
}