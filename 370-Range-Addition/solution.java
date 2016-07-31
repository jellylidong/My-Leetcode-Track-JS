public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];
        for(int[] update: updates){
            int start = update[0];
            int end = update[1];
            int inc = update[2];
            
            // for(int i = start; i <= end; i++){
            //     ans[i] += inc;
            // }
            ans[start] += inc;
            if(end+1 < length)
                ans[end+1] -= inc;
        }
        
        int sum = 0;
        for(int i = 0; i < length; i++){
            sum += ans[i];
            ans[i] = sum;
        }
        
        return ans;
    }
}