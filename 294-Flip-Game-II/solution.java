public class Solution {
    public boolean canWin(String s) {
        if(s.length() <= 1) return false;
        
        boolean res = false;
        for(int i = 0; i < s.length()-1; i++){
            if(s.substring(i, i+2).equals("++")){
                String newStr = s.substring(0, i) + "--" + s.substring(i+2);
                res = res || !canWin(newStr);
            }
            if(res)
                break;
        }
        
        return res;
    }
}