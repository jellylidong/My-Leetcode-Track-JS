public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n < 1)  return false;
        
        //method 1: devide by 2
        // while(n%2 == 0){
        //     n >>= 1;
        // }
        // return n == 1;
        
        //method 2: bit count
        //for a power-of-2 number, only the left most bit is set, 
        //ie it's form is X01000...0B, so num-1 =x00111...1B
        //so num&(num-1) == 0
        
        return (n&(n-1)) == 0;
        
    }
}