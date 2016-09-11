public class Solution {
    //method 1: array
    // public int trap(int[] height) {
    //     int ans = 0;
        
    //     int lo = 0;
    //     int hi = height.length-1;
        
    //     while(lo < hi){
    //         int left = height[lo];
    //         int right = height[hi];
            
    //         if(left <= right){
    //             while(lo <= hi && left >= height[lo]){
    //                 ans += (left - height[lo]);
    //                 lo++;
    //             }
    //         }
    //         else {
    //             while(lo <= hi && right >= height[hi]){
    //                 ans += (right - height[hi]);
    //                 hi--;
    //             }
    //         }
    //     }
        
    //     return ans;
    // }
    
    
    //method 2: stack
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>(); //stores index of height
        int ans = 0;
        int i = 0;
        while(i < height.length){
            if(stack.isEmpty() || height[stack.peek()] >= height[i]){
                stack.push(i++);
            }
            else{
                int pre = stack.pop();
                int delta = stack.isEmpty()? 0:(Math.min(height[stack.peek()], height[i]) - height[pre])*(i-stack.peek()-1);
                ans += delta;        
            }
        }
        return ans;
    }
}