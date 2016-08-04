public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n, n, "", ans);
        return ans;
    }
    
    public void helper(int left, int right, String cur, List<String> ans){
        if(left == 0 && right == 0){
            ans.add(cur);
            return;
        }
        if(left < 0 || right < 0)   return;
        if(left <= right)   helper(left-1, right, cur+"(", ans);
        if(right >=left-1)  helper(left, right-1, cur+")", ans);
    }
}