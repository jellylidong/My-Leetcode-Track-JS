public class Solution {
    public boolean isMatch(String s, String p) {
        var sId = 0, pId = 0;
        var preSId = 0, prePId = -1;
        
        while(sId < s.length){
            if(pId < p.length && (p[pId] == '?' || p[pId] == s[sId])){
                pId++;
                sId++;
            }
            else if(pId < p.length && p[pId] = '*'){
                prePId = pId;
                preSId = sId;
                pId++;
            }
            else if(prePId != -1){
                pId = prePId + 1;
                preSId++;
                sId = preSId;
            }
            else    return false;
        }
        while(pId < p.length)
        
    }
}