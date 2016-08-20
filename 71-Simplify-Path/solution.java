public class Solution {
    public String simplifyPath(String path) {
        String[] ss = path.split("/");
        //note for string start with "/", for exmaple"/a/b
        //after split we will get {"", "a", "b"}
        //for string "/a//b", we will get {"", "a", "", "b"}
        Stack<String> stack = new Stack<>();
        
        // for(String s: ss){System.out.println(s+" ");}
        for(String s: ss){
            if(s.equals(".") || s.equals(""))   continue;
            else if(s.equals("..")){
                //note here, we should not write all conditions into one if
                //otherwise we may put the ".." "." into stack when stack is empty
                if(!stack.isEmpty())
                    stack.pop();
            }
            else
                stack.push(s);
        }
        
        String ans = "";
        while(!stack.isEmpty()){
            String cur = stack.pop();
            ans = "/" + cur + ans;
        }
        
        return ans.length() == 0? "/":ans;
    }
}