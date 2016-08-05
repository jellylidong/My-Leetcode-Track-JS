public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ans = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0 || k == 0)    return ans;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(k, new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                return (int)(p1.sum - p2.sum);
            }
        });
        
        for(int i = 0; i < nums1.length; i++){
            pq.offer(new Pair(0, nums1[i], nums2[0]));
        }
        // for(int i = 0; i < k && !pq.isEmpty() && pq.peek().index+1 < nums2.length; i++){
        //     Pair cur = pq.poll();
        //     ans.add(new int[] {cur.num1, cur.num2});
        //     pq.offer(new Pair(cur.index+1, cur.num1, nums2[cur.index+1]));
        // }
        
        //note we should not put the pq.peek().index+1 < nums2.length in the for loop condition
        //because there may still be pair in the pq, if we do so, we will get early termination
        for(int i = 0; i < k && !pq.isEmpty(); i++){
            Pair cur = pq.poll();
            ans.add(new int[] {cur.num1, cur.num2});
            if(cur.index+1 < nums2.length){
                pq.offer(new Pair(cur.index+1, cur.num1, nums2[cur.index+1]));
            }
        }
        
        return ans;
    }
    
    public class Pair{
        int index; //used to store index of num2
        long sum;
        int num1, num2;
        Pair(int index, int n1, int n2){
            this.index = index;
            this.num1 = n1;
            this.num2 = n2;
            this.sum = n1 + n2;
        }
    }
    
    
}