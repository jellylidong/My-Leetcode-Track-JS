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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ans = new ArrayList<>();
        if(intervals.size() == 0){
            ans.add(newInterval);
            return ans;
        }
        int i = 0;
        for(; i < intervals.size(); i++){
            Interval cur = intervals.get(i);
            if(cur.end < newInterval.start) ans.add(cur);
            else{
                if(newInterval.end < cur.start){
                    ans.add(newInterval);
                    newInterval = cur;
                }
                else{
                    newInterval.start = Math.min(newInterval.start, cur.start);
                    newInterval.end = Math.max(newInterval.end, cur.end);
                }
                break;
            }
        }
        while(i < intervals.size() && newInterval.end >= intervals.get(i).start){
            Interval cur = intervals.get(i);
            newInterval.start = Math.min(newInterval.start, cur.start);
            newInterval.end = Math.max(newInterval.end, cur.end);
            i++;
        }
        ans.add(newInterval);
        for(; i < intervals.size(); i++){
            ans.add(intervals.get(i));   
        }
        
        return ans;
    }
}