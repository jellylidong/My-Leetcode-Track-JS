public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> ans = new ArrayList<>();
        if(n == 0)  return ans;
        helper(n, "", ans);
        return ans;
    }
    
    public void helper(int n, String s, List<String> ans){
        if(n == 0) { 
            if(s.length() == 1 || s.charAt(0) != '0')
                ans.add(s);
        }
        else{
            if(n%2 == 1){
                helper(n-1, "1", ans);
                helper(n-1, "0", ans);
                helper(n-1, "8", ans);
            }
            else{
                helper(n-2, 0+s+0, ans);
                helper(n-2, 1+s+1, ans);
                helper(n-2, 6+s+9, ans);
                helper(n-2, 8+s+8, ans);
                helper(n-2, 9+s+6, ans);
            }
        }
    }
}