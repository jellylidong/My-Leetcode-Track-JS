public class Solution {
    public String shortestPalindrome(String s) {
        
        int[] pi = genPMT(s);
        
        String revs = new StringBuilder(s).reverse().toString();
        int overlap = maxOverlap(revs, s, pi);
        
        return revs + s.substring(overlap);
    }
    
    public int maxOverlap(String s1, String s2, int[] pi){
        int begin = 0;
        int matched = 0;
        int len = s1.length();
        
        while(begin < len){
            if(matched < len && s1.charAt(begin+matched) == s2.charAt(matched)){
                matched++;
                if(begin + matched == len)
                    return matched;
            }
            else{
                if(matched == 0)    begin++;
                else{
                    begin += matched - pi[matched-1];
                    matched = pi[matched-1];
                }
            }
        }
        return 0;
    }
    
    public int[] genPMT(String s){
        int begin = 1; //?
        int matched = 0;
        int len = s.length();
        int[] pi = new int[len];
        
        while(begin + matched < len){
            if(s.charAt(begin+matched) == s.charAt(matched)){
                matched++;
                pi[begin+matched-1] = matched;
            }
            else{
                if(matched == 0)    begin++;
                else{
                    begin += matched - pi[matched-1];
                    matched = pi[matched-1];
                }
            }
        }
        
        return pi;
    }
}