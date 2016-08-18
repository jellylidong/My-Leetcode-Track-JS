public class ZigzagIterator {

    List<Integer> l1, l2, curL;
    int i1, i2, curI;
    int switcher;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.l1 = v1;
        this.l2 = v2;
        this.i1 = 0;
        this.i2 = 0;
        
        this.curL = l1;
        this.curI = 0;
        
        this.switcher = 0;
    }

    public int next() {
        int res = curL.get(curI);
        if(switcher == 0) i1++;
        if(switcher == 1) i2++;
        switcher = (switcher+1)%2;
        curI = switcher == 0? i1:i2;
        curL = switcher == 0? l1:l2;
        return res;
    }

    public boolean hasNext() {
        if(curI < curL.size())  return true;
        else{
            switcher = (switcher+1)%2;
            curI = switcher == 0? i1:i2;
            curL = switcher == 0? l1:l2;
            if(curI < curL.size())  return true;
            else    return false;
        }
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */