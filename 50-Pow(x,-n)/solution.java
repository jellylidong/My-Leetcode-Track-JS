public class Solution {
    
    //corner cases
    //when n == int_min, -int_min gets overflow
    //n == 0, we can return 1 only when x != 0

    public double myPow(double x, int n) {
        return helper(x, n);
    }
    
    public double helper(double x, long n){
        //int_min = -2147483648
        //int_max = 2147483647
        if(n < 0)   return helper(1/x, -n);
        if(x == 0)  return 0;
        else if(n == 0) return 1;
        
        if(n%2 == 0)    return helper(x*x, n/2);
        else    return x*helper(x*x, n/2);
    }
}