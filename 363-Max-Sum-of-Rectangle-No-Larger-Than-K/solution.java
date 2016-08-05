public class Solution {
    
    //the overall time complexity R*R*logC OR C*C*log R
    //since C >> R, so R*R*logC is amller
    
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        if(row == 0)    return 0;
        int col = matrix[0].length;
        if(col == 0)    return 0;
        
        int ans = Integer.MIN_VALUE;
        
        //each time go from i to col, binary search each sum use a pq
        for(int c = 0; c < col; c++){
            int[] sums = new int[row]; //sum[i] is the sum of matrix[i][c ... col]
            for(int cc = c; cc < col; cc++){
                
                for(int r = 0; r < row; r++){
                    sums[r] += matrix[r][cc];
                }
                
                TreeSet<Integer> set = new TreeSet<>();
                //why set.add(0)?
                //because the sum range can start with 0
                //if we we don't add 0, we can only get sum start with index 1
                //take e.g [1,1,5] and k = 3 as an example if you still don't understand
                set.add(0);
                int curSum = 0;
                for(int sum: sums){
                    curSum += sum;
                    Integer num = set.ceiling(curSum-k);
                    //num is null or num is the min number >= curSum-k
                    //so curSum - num <= k
                    if(num != null){
                        ans = Math.max(ans, curSum-num);
                    }
                    set.add(curSum);
                }
            }
        }
        
        return ans;
    }
}