public class MovingAverage {

    /** Initialize your data structure here. */
    int size;
    int count;
    int sum;
    Queue<Integer> q;
    public MovingAverage(int size) {
        this.size = size;
        this.count = 0;
        this.sum = 0;
        this.q = new LinkedList<>();
    }
    
    public double next(int val) {
        if(q.size() == size){
            sum -= q.poll();
        }
        q.offer(val);
        sum += val;
        if(count < size)    count++;
        return (double)sum/count;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */