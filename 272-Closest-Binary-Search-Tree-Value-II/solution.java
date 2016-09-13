/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        preIterator pre = new preIterator(root, target);
        nextIterator next = new nextIterator(root, target);
        if(pre.hasNext() && next.hasNext() && pre.nextVal() == next.nextVal())
            pre.next();
            
        List<Integer> ans = new ArrayList<>();
        while(k > 0){
            if(pre.hasNext() && next.hasNext()){
                double diff1 = Math.abs(target - pre.nextVal());
                double diff2 = Math.abs(next.nextVal() - target);
                if(diff1 < diff2)   ans.add(pre.next());
                else ans.add(next.next());
            }
            else if(pre.hasNext()){
                ans.add(pre.next());
            }
            else if(next.hasNext()){
                ans.add(next.next());
            }
            k--;
        }
        return ans;
    }
    
    public class preIterator{
        Stack<TreeNode> stack;
        preIterator(TreeNode root, double target){
            
            stack = new Stack<>();
            while(root != null){
                if(root.val == target){
                    stack.push(root);
                    break;
                }
                else if(root.val > target){
                    root = root.left;
                }
                else{
                    stack.push(root);
                    root = root.right;
                }
            }
        }
        
        public boolean hasNext(){
            return !stack.isEmpty();
        }
        
        public int next(){
            TreeNode cur = stack.pop();
            int res = cur.val;
            cur = cur.left;
            while(cur != null){
                stack.push(cur);
                cur = cur.right;
            }
            return res;
        }
        public int nextVal(){
            return stack.peek().val;
        }
    }
    
    public class nextIterator{
        Stack<TreeNode> stack;
        nextIterator(TreeNode root, double target){
            stack = new Stack<>();
            while(root != null){
                if(root.val == target){
                    stack.push(root);
                    break;
                }
                else if(root.val < target){
                    root = root.right;
                }
                else{
                    stack.push(root);
                    root = root.left;
                }
            }
        }
        
        public boolean hasNext(){
            return !stack.isEmpty();
        }
        
        public int next(){
            TreeNode cur = stack.pop();
            int res = cur.val;
            cur = cur.right;
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            return res;
        }
        public int nextVal(){
            return stack.peek().val;
        }
    }
}