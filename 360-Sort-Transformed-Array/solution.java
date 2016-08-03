public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] ans = new int[nums.length];
        if(a == 0){
            for(int i = 0; i < nums.length; i++)
                ans[i] = function(a, b, c, nums[i]);
            if(b < 0){
                int lo = 0;
                int hi = nums.length-1;
                while(lo < hi){
                    int tmp = ans[lo];
                    ans[lo] = ans[hi];
                    ans[hi] = tmp;
                    lo++;
                    hi--;
                }
            }
            return ans;
        }
        double mid = -(double)b/a/2;
        int i = 0;
        while(i < nums.length && nums[i] < mid)
            i++;
        // System.out.println(i);
        int left = i-1;
        int right = i;
        int curId = 0;
        while(left >= 0 && right <= nums.length-1){
            if(Math.abs(mid-nums[left]) < Math.abs(mid-nums[right])){
                ans[curId] = function(a, b, c, nums[left]);
                left--;
            }
            else {
                ans[curId] = function(a, b, c, nums[right]);
                right++;
            }
            curId++;
        }
        if(left >= 0){
            // curId = 
            while(left >= 0){
                ans[curId] = function(a, b, c, nums[left]);
                left--;
                curId++;
            }
        }
        while(right <= nums.length-1){
            ans[curId] = function(a, b, c, nums[right]);
            right++;
            curId++;
        }
        if(a < 0){
            int lo = 0;
            int hi = nums.length-1;
            while(lo < hi){
                int tmp = ans[lo];
                ans[lo] = ans[hi];
                ans[hi] = tmp;
                lo++;
                hi--;
            }
        }
        return ans;
    }
    
    public int function(int a, int b, int c, int x){
        return a*x*x + b*x + c;
    }
}