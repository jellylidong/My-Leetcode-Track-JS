public class MedianFinder {

    // Adds a number into the data structure.
    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); //peek is max value
    PriorityQueue<Integer> right = new PriorityQueue<>();//peek is min value
    //values in left are smaller than right
    //always keep right.size() >= left.size()
    public void addNum(int num) {
        right.offer(num);
        left.offer(right.poll());
        if(left.size() > right.size()){
            right.offer(left.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(left.size() == right.size()){
            return (double)(left.peek()+right.peek())/2;
        }
        else
            return (double)right.peek();
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();