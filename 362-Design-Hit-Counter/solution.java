public class HitCounter {

    /** Initialize your data structure here. */
    int[] times;
    int[] count;
    public HitCounter() {
        times = new int[300];
        count = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int id = timestamp%300;
        if(times[id] != timestamp){
            times[id] = timestamp;
            count[id] = 1;
        }
        else{
            count[id]++;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int total = 0;
        for(int i = 0; i < 300; i++){
            if(times[i] <= timestamp && times[i] >= timestamp-300+1)
                total += count[i];
        }
        return total;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */