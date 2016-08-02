public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //this problem can be transformed to a merge n sorted array problem
        //n = matirx.length, each row is a array, 
        //what we need to do is to find the min from these n arrays 
        //and +1 to index of the array that has the min value
        //to find the min value quickly, we can use a priorityqueue, 
        //which stores row-col pairs and sorted according to the matrix[row][col] value
        PriorityQueue<Pair> pq = new PriorityQueue(k, new pairComparator());
        pq.offer(new Pair(0, 0, matrix));
        int count = 0;
        // for(int i = 0; i < matrix.length; i++){
        //     pq.offer(new Pair(i, 0, matrix));
        // }
        while(true){
            Pair cur = pq.poll();
            count++;
            if(count == k)
                return cur.val;
            if(cur.col+1 < matrix[0].length){
                pq.offer(new Pair(cur.row, cur.col+1, matrix));
                if(cur.col == 0 && cur.row+1 < matrix.length)
                    pq.offer(new Pair(cur.row+1, 0, matrix));
            }
            
        }
    }
    
    public class Pair{
        int row;
        int col;
        int val;
        Pair(int r, int c, int[][] matrix){
            this.row = r;
            this.col = c;
            this.val = matrix[r][c];
        }
    }
    
    public class pairComparator implements Comparator<Pair>{
        @Override
        public int compare(Pair p1, Pair p2){
            return p1.val-p2.val;
        }
    }
}