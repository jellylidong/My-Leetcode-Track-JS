/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length == 0)   return 0;
        
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        
        PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2){
                return i1.end - i2.end;
            }
        });
        
        pq.offer(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            Interval cur = pq.peek();
            if(cur.end <= intervals[i].start)
                pq.poll();
            pq.offer(intervals[i]);
        }
        
        return pq.size();
    }
}