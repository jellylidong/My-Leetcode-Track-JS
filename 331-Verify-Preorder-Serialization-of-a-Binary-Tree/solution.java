public class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        String[] ss = preorder.split(",");
        
        for(String s: ss){
            if(s.equals("#")){
                while(!stack.isEmpty() && stack.peek().equals("#")){
                    stack.pop();
                    if(stack.isEmpty()) return false;
                    stack.pop();
                }
                stack.push("#");
            }
            else{
                stack.push(s);
            }
        }
        
        return stack.size() == 1 && stack.peek().equals("#");
    }
    
    /*
    when you iterate through the preorder traversal string, for each char:

    case 1: you see a number c, means you begin to expand a new tree rooted with c, you push it to stack
    
    case 2.1: you see a #, while top of stack is a number, you know this # is a left null child, put it there as a mark for next coming node k to know it is being the right child.
    
    case 2.2: you see a #, while top of stack is #, you know you meet this # as right null child, you now cancel the sub tree (rooted as t, for example) with these two-# children. But wait, after the cancellation, you continue to check top of stack is whether # or a number:
    
    ---- if a number, say u, you know you just cancelled a node t which is left child of u. You need to leave a # mark to the top of stack. So that the next node know it is a right child.
    
    ---- if a #, you know you just cancelled a tree whose root, t, is the right child of u. So you continue to cancel sub tree of u, and the process goes on and on.
    
    */
}