public class Solution {
    public void wiggleSort(int[] nums) {
        
        int len = nums.length;
        int mid = findKth(nums, 0, nums.length-1, (len+1)/2);
        int lo = 0;
        int hi = nums.length-1;
        int i = 0;
        while(i <= hi){
            if(nums[mapIndex(i, len)] > mid){
                swap(nums, mapIndex(i, len), mapIndex(lo, len));
                lo++;
                i++;
            }
            else if(nums[mapIndex(i, len)] < mid){
                swap(nums, mapIndex(i, len), mapIndex(hi, len));
                hi--;
            }
            else{
                i++;
            }
        }
        
    }
    
    public int mapIndex(int i, int len){
        return (1 + 2*i) % (len | 1);
    }
    
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    //find kth small number, k is starting from 0
    public int findKth(int[] nums, int lo, int hi, int k){
        int pivot = nums[hi];
        int i = lo;
        int j = hi;
        
        while(i < j){
            if(nums[i] > pivot){
                j--;
                swap(nums, i, j);
            }
            else if(nums[i] <= pivot){
                i++;
            }
        }
        swap(nums, i, hi);
        int count = i-lo+1; //count of numbers <= numdsi];
        if(count > k)  return findKth(nums, lo, i-1, k);
        else if(count == k) return nums[i];
        else return findKth(nums, i+1, hi, k-count);
    }
}