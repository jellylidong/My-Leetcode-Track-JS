public class Solution {
    public int trap(int[] height) {
        int ans = 0;
        
        int lo = 0;
        int hi = height.length-1;
        
        while(lo < hi){
            int left = height[lo];
            int right = height[hi];
            
            if(left <= right){
                while(lo <= hi && left >= height[lo]){
                    ans += (left - height[lo]);
                    lo++;
                }
            }
            else {
                while(lo <= hi && right >= height[hi]){
                    ans += (right - height[hi]);
                    hi--;
                }
            }
        }
        
        return ans;
    }
}