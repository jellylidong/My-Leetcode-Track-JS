public class Solution {
    public boolean isPowerOfThree(int n) {
        // if(n <= 0)  return false;
        // int t = (int)Math.pow(3, (int)Math.log10(Integer.MAX_VALUE)/Math.log10(3));
        // return t%n == 0;
        //1162261467 is the largest power3 integer
        // System.out.println(1.1%1);
        return (Math.log10(n)/Math.log10(3))%1 == 0;
    }
}