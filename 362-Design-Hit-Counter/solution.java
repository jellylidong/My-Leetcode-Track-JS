public class HitCounter {

    /** Initialize your data structure here. */
    TreeMap<Integer, Integer> treeMap;
    public HitCounter() {
        treeMap = new TreeMap<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if(!treeMap.containsKey(timestamp))
            treeMap.put(timestamp, 0);
        treeMap.put(timestamp, treeMap.get(timestamp)+1);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        Map<Integer, Integer> map = treeMap.tailMap(timestamp-300+1);
        int sum = 0;
        for(int val: map.values()){
            sum += val;
        }
        return sum;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */