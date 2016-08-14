public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        if(nums.length == 0){
            ans.add(lower == upper? lower+"": lower+"->"+upper);
            return ans;
        }
        
        if(lower < nums[0]) ans.add(lower == nums[0]-1? lower+"": lower+"->"+(nums[0]-1));
        
        int i = 1;
        while(i < nums.length){
            while(i < nums.length && nums[i] == nums[i-1]+1)
                i++;
            if(i == nums.length){    
                
                break;
            }
            else{
                int num1 = nums[i-1]+1;
                int num2 = nums[i]-1;
                ans.add(num1 == num2? num1+"":num1+"->"+num2);
                i++;
            }
        }
        
        int num1 = nums[i-1]+1;
        int num2 = upper;
        if(num1 <= num2) //for case lower=-1, upper=-1, nums={-1}, we must make sure num1 <= num2
            ans.add(num1 == num2? num1+"":num1+"->"+num2);
        
        return ans;
    }
}