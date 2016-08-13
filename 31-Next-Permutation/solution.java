public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1)    return;
        int i = nums.length-1;
        //step 1: find the first peak from right
        //then nums[i...len-1] is in descending order
        while(i-1 >= 0){
            if(nums[i-1] < nums[i]) break;
            else i--;
        }
        if(i == 0){
            //corner case, if the whole array is already desending
            //it means current array is already the last one ie 4321, 
            //we only need to reverse the whole array so that it starts from the first array, ie 1234
            reverse(nums, 0, nums.length-1);
            return;
        }
        
        //step 2
        //find the right most number in nums[i...len-1] that is > nums[i-1]
        //and swap it with nums[i-1]
        //so that the next permutation is minimum
        int minId = nums.length-1;
        while(minId >= i){
            //since nums[i...len-1] is in descending order
            //so while we are going from right to left, the first number that nums[minId] > nums[i-1]
            //is the position we are looking for to swap with nums[i-1]
            if(nums[minId] > nums[i-1])
                break;
            minId--;
        }
        int tmp = nums[i-1];
        nums[i-1] = nums[minId];
        nums[minId] = tmp;
        
        //step 3
        //after step 2 done, nums[i...len-1] is still in descending order
        //reverse it so that new number is minimum
        reverse(nums, i, nums.length-1);
        
        
    }
    
    public void reverse(int[] nums, int lo, int hi){
        while(lo < hi){
            int tmp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = tmp;
            lo++;
            hi--;
        }
    }
    
    
}