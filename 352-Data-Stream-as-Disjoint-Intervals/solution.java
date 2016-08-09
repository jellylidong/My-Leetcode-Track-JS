/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {

    /** Initialize your data structure here. */
    TreeMap<Integer, Interval> map;
    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int val) {
        Map.Entry<Integer, Interval> lo = map.floorEntry(val);
        Map.Entry<Integer, Interval> hi = map.ceilingEntry(val);
        
        if(lo != null && hi != null){
            if(lo.getValue().end+1 == val && val+1 == hi.getValue().start){
                lo.getValue().end = hi.getValue().end;
                map.remove(hi.getKey());
                return;
            }
            // else if(lo.getValue().start == val || lo.getValue().end == val ||
            //         hi.getValue().start == val || hi.getValue().end == val)
            //         return;
        }
        if(lo != null){
            if(lo.getValue().end+1 == val){
                lo.getValue().end = val;
                return;
            }
            if(lo.getValue().start == val || lo.getValue().end == val || (lo.getValue().start < val && lo.getValue().end > val))
                return;
        }
        if(hi != null){
            if(hi.getValue().start == val+1){
                hi.getValue().start = val;
                return;
            }
            if(hi.getValue().start == val || hi.getValue().end == val || (hi.getValue().start < val && hi.getValue().end > val))
                return;
        }
        
        map.put(val, new Interval(val, val));
            
      
        
    }
    
    public List<Interval> getIntervals() {
        List<Interval> ans = new ArrayList<>();
        ans.addAll(map.values());
        return ans;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */