public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < s.length()-1; i++){
            if(s.substring(i, i+2).equals("++")){
                String newStr = s.substring(0, i) + "--" + s.substring(i+2);
                ans.add(newStr);
            }
        }
        return ans;
    }
}