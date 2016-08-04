public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] != arr2[0])  return arr1[0]-arr2[0];
                else    return arr2[1] - arr1[1];
            }
        });
        
        int[] dp = new int[envelopes.length];
        int len = 0;
        for(int[] cur: envelopes){
            int id = Arrays.binarySearch(dp, 0, len, cur[1]);
            if(id < 0)  id = -(id+1);
            dp[id] = cur[1];
            if(id == len)   len++;
        }
        return len;
    }
}