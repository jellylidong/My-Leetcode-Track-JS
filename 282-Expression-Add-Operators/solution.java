public class Solution {
    //only find DFS solution, can not find D&C solution
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        if(num.length() == 0) return ans;
        helper(0, num, "", 0, 0, target, ans);
        return ans;
    }
    
    public void helper(int curId, String num, String curStr, long preVal, long curVal, int target, List<String> ans){
        if(curId == num.length() && curVal == target){
            ans.add(curStr);
        }
        else{
            for(int i = curId+1;  i <= num.length(); i++){
                String nextStr = num.substring(curId, i);
                //number start with 0 but not 0 is invalid
                if(nextStr.length() > 1 && nextStr.charAt(0) == '0')
                    return;
                long nextVal = Long.parseLong(nextStr);
                if(curStr.length() == 0){
                    helper(i, num, nextStr, nextVal, nextVal, target, ans);
                }
                else{
                    helper(i, num, curStr+"+"+nextStr, nextVal, curVal+nextVal, target, ans);
                    helper(i, num, curStr+"-"+nextStr, -nextVal, curVal-nextVal, target, ans);
                    helper(i, num, curStr+"*"+nextStr, preVal*nextVal, curVal-preVal+preVal*nextVal, target, ans);
                }
            }
        }
    }
}