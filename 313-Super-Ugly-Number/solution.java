public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ans = new int[n];
        int[] ids = new int[primes.length];
        ans[0] = 1;
        
        for(int i = 1; i < n; i++){
            int next = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; j++){
                next = Math.min(next, ans[ids[j]]*primes[j]);
            }
            
            ans[i] = next;
            
            for(int j = 0; j < primes.length; j++){
                if(ans[i] == ans[ids[j]]*primes[j])
                    ids[j]++;
            }
        }
        
        return ans[n-1];
    }
}