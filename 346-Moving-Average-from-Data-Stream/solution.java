public class MovingAverage {

    /** Initialize your data structure here. */
    int size;
    int count;
    int sum;
    int index;
    int[] nums;
    public MovingAverage(int size) {
        this.size = size;
        this.count = 0;
        this.sum = 0;
        this.index = 0;
        this.nums = new int[size];
    }
    
    public double next(int val) {
        if(index == size){
            index = 0;
        }
        sum -= nums[index];
        nums[index] = val;
        index++;
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