public class Solution {
    public boolean isReflected(int[][] points) {
        //find if ther is a common mirror for all points
        
        HashSet<String> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int[] p: points){
            min = Math.min(min, p[0]);
            max = Math.max(max, p[0]);
            set.add(p[0]+"-"+p[1]);
        }
        
        int m = (min+max)/2;
        for(int[] p: points){
            // String newS = (p[0]>= m? m-(p[0]-m): m+(m-p[0])) + ("-"+p[1]);
            String newS = (max+min-p[0]) + "-" + p[1];
            if(!set.contains(newS)) return false;
        }
        
        return true;
    }
}