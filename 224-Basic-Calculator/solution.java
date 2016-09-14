public class Solution {
    public int calculate(String s) {
        int num = 0;
        int sign = 1;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = 10*num + (c-'0');
            }
            else if(c == '('){
                stack.push(ans);
                stack.push(sign);
                num = 0;
                sign = 1;
                ans = 0;
            }
            else if(c == ')'){
                ans += sign*num;
                ans *= stack.pop();
                ans += stack.pop();
                num = 0;
                sign = 1;
            }
            else if(c == '+'){
                ans += sign*num;
                num = 0;
                sign = 1;
            }
            else if(c == '-'){
                ans += sign*num;
                num = 0;
                sign = -1;
            }
        }
        
        ans += sign*num;
        return ans;
        
    }
}