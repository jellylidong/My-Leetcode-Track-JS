public class Solution {
    public String decodeString(String s) {
        s = "1["  + s + ']';
        Stack<String> stack = new Stack<>();
        String cur = "";
        
        for(int i = 0; i < s.length(); i++){
            // System.out.println(i);
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                if(cur.length() != 0 && !Character.isDigit(cur.charAt(0))){
                    stack.push(cur);
                    cur = "";
                }
                cur += c;
            }
            else if(c == '['){
                stack.push(cur);
                cur = "";
            }
            else if(c == ']'){
                String str = cur;
                cur = "";
                while(!stack.isEmpty()){
                    String tmp = stack.peek();
                    if(Character.isDigit(tmp.charAt(0)))    break;
                    else str = stack.pop() + str;
                }
                int num = Integer.parseInt(stack.pop());
                StringBuilder sb = new StringBuilder();
                for(int k = 0; k < num; k++)    sb.append(str);
                stack.push(sb.toString());
            }
            else cur += c;
            // System.out.println(stack.isEmpty()? "null":stack.peek());
        }
        
        String ans = "";
        while(!stack.isEmpty()) ans = stack.pop() + ans;
        
        return ans;
        
    }
}