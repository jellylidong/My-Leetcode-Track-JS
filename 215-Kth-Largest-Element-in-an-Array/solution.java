public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int index = quickSelect(nums, 0, nums.length-1, nums.length-k+1);
        return nums[index];
    }
    
    public int quickSelect(int[] nums, int lo, int hi, int k){
        //looking for the kth number between lo and hi, both lo and hi are inclusive and k starts from 1
        int i = lo;
        int j = hi;
        int pivot = nums[hi];
        while(i < j){
            if(nums[i] > pivot){
                j--;
                swap(nums, i, j);
            }
            else{    i++;}
        }
        // System.out.println(i + " " + j);
        swap(nums, i, hi);
        
        int count = i-lo+1; //count of numbers <= pivot
        // System.out.println("count: " + count);
        if(count == k)  return i; 
        else if(count < k)  return quickSelect(nums, i+1, hi, k-count);
        else    return quickSelect(nums, lo, i-1, k);
    }
    
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}