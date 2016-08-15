public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] n1, int[] n2){
                return n1[0] - n2[0];
            }
            //n[0] current value, n[1] current index, n[2] base value
        });
        
        int[] ans = new int[n];
        ans[0] = 1;
        
        for(int i = 0; i < primes.length; i++){
            pq.offer(new int[] {primes[i], 0, primes[i]});
        }
        
        for(int i = 1; i < n; i++){
            int next = pq.peek()[0];
            ans[i] = next;
            while(pq.peek()[0] == next){
                int[] cur = pq.poll();
                pq.offer(new int[] {cur[2]*ans[cur[1]], cur[1]+1, cur[2]});
            }
        }
        
        return ans[n-1];
    }
}