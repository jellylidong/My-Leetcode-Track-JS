public class Solution {
    public String shortestPalindrome(String s) {
        if(s.length() == 0) return "";
        
        int[] kmpS = new int[s.length()];
        int j = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(j)){
                kmpS[i] = 1 + kmpS[i-1];
                j++;
            }
            else{
                while(j != 0 && s.charAt(i) != s.charAt(j))
                    j = kmpS[j-1];
                if(s.charAt(i) == s.charAt(j)){
                    kmpS[i] = j+1;
                    j++;
                }
            }
        }
        
        String r = new StringBuilder(s).reverse().toString();
        int[] kmpR = new int[r.length()];
        j = 0;
        for(int i = 0; i < r.length(); i++){
            if(s.charAt(j) == r.charAt(i)){
                kmpR[i] = j==0? 1:kmpR[i-1]+1;
                j++;
            }
            else{
                while(j != 0 && s.charAt(j) != r.charAt(i))
                    j = kmpS[j-1];
                if(s.charAt(j) == r.charAt(i)){
                    kmpR[i] = j+1;
                    j++;
                }
            }
        }
        
        
        
        // String rev = new StringBuilder(s).reverse().toString();
        
        return r.substring(0, r.length()-kmpR[r.length()-1]) + s;
    }
    
    
}