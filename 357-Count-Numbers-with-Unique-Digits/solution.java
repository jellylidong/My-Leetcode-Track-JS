public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        //a combinatino problem
        //it can be regarded as given 0...9
        //choose at most n of these numbers to make numbers that have unique digits
        
        if(n == 0)  return 1;
        if(n == 1)  return 10;
        if(n == 2)  return 91;
        
        int pre = 81;
        int sum = 81 + 10;
        for(int i = 3; i <= n && (10-(i-1)) > 0; i++){
            int next = pre * (10-(i-1)); //there are already i-1 numbers are used
            sum += next;
            pre = next;
        }
        
        return sum;
    }
}