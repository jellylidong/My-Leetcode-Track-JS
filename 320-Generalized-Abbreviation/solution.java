public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<>();
        helper(ans, word, "", 0, 0);
        return ans;
    }
    
    //this can be optimized by using StringBuilder to store the cur
    //after each dfs, we should remove the last char of the stringbuilder
    public void helper(List<String> ans, String word, String cur, int p, int count){
        if(p == word.length()){
            if(count > 0)   cur += count;
            ans.add(cur);
        }
        else{
            //not abbr
            helper(ans, word, cur + (count > 0? count:"") + word.charAt(p), p+1, 0);
            
            //abbr
            helper(ans, word,cur, p+1, count+1);
        }
    }
}