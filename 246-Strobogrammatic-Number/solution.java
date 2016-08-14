public class Solution {
    public boolean isStrobogrammatic(String num) {
        int lo = 0;
        int hi = num.length()-1;
        while(lo <= hi){
            char n1 = num.charAt(lo);
            char n2 = num.charAt(hi);
            if(!((n1=='6' && n2=='9') || (n1=='9' && n2=='6') || 
               (n1=='1' && n2=='1') || (n1=='8' && n2=='8') || (n1=='0' && n2=='0')))
                return false;
            lo++;
            hi--;
        }
        
        return true;
    }
}