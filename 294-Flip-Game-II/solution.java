public class Solution {
    public boolean canWin(String s) {
        if(s.length() <= 1) return false;
        
        HashSet<String> winSet = new HashSet<>();
        return helper(s, winSet);
    }
    
    public boolean helper(String s, HashSet<String> winSet){
        if(winSet.contains(s))  return true;
        for(int i = 0; i < s.length()-1; i++){
            if(s.substring(i, i+2).equals("++")){
                String newStr = s.substring(0, i) + "--" + s.substring(i+2);
                boolean oppRes = helper(newStr, winSet);
                if(oppRes == true){
                    winSet.add(newStr);
                }
                else
                    return true;
            }
        }
        return false;
    }
}