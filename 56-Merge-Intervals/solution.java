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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        if(intervals.size() == 0)   return ans;
        
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        
        Interval pre = intervals.get(0);
        ans.add(pre);
        for(int i = 1; i < intervals.size(); i++){
            Interval cur = intervals.get(i);
            if(cur.start <= pre.end)
                pre.end = Math.max(pre.end, cur.end);
            else{
                pre = cur;
                ans.add(pre);
            }
        }
        
        return ans;
    }
}