public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        var len = matrix.length;
        var loR = 0, hiR = len-1;
        var loC = 0, hiC = len-1;
        
        var kR
        
        while(loR*len+loC+1 != k){
            var midR = loR + Math.floor((hiR-loR)/2);
            var midC = loC + Math.floor((hiC-loC)/2);
            
        }
    }
}