public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<>();
        if(len < 2){ 
            for(int n: nums)    ans.add(n);
            return ans;
        }
        
        int[] count = new int[len]; //count[i] means i has count[i] dividend //bei chushu
        int[] parent = new int[len]; //parent[i] is the id of its dividend with max subset //bei chu shu
        
        Arrays.sort(nums);
        int maxSize = 0;
        int maxId = 0;
        
        for(int i = len-1; i >= 0; i--){
            for(int j = i; j < len; j++){ //j >= i
                if(nums[j]%nums[i] == 0 && count[i] < 1 + count[j]){
                    count[i] = 1+count[j];
                    parent[i] = j;
                    if(count[i] > maxSize){
                        maxSize = count[i];
                        maxId = i;
                    }
                }
            }
        }
        
        for(int i = 0; i < maxSize; i++){
            ans.add(nums[maxId]);
            maxId = parent[maxId];
        }
        return ans;
    }
}