public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length-1, nums.length-k); //the kth, k starts from 0
    }
    
    public int quickSelect(int[] nums, int lo, int hi, int k){
        int pivot = nums[hi];
        int s = lo;
        int e = hi;
        
        while(s < e){
            if(nums[s] > pivot){
                e--;
                swap(nums, s, e);
            }
            else s++;
        }
        swap(nums, s, hi);
        if(lo+k == s)   return nums[s];
        else if(lo+k < s)   return quickSelect(nums, lo, s-1, k);
        else return quickSelect(nums, s+1, hi, k-(s-lo+1));
    }
    
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}