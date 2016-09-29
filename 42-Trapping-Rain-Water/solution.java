public class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i = 0; i < height.length; i++){
        	if(stack.isEmpty() || height[i] <= height[stack.peek()]){
        		stack.push(i);
        	}
        	else{
        		while(!stack.isEmpty() && height[i] >= height[stack.peek()]){
        			int pre = stack.pop();
        			if(!stack.isEmpty()){
        				int dh = Math.min(height[i],  height[stack.peek()]) - height[pre];
        				int dx = i - stack.peek()-1;
        				res += dh*dx;
        			}
        		}
        		stack.push(i);
        	}
        }
        
        return res;
    }
}