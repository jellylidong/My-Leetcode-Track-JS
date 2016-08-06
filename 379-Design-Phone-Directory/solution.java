public class PhoneDirectory {

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    HashSet<Integer> used;
    Queue<Integer> released;
    int max;
    int curNum;
    public PhoneDirectory(int maxNumbers) {
        used = new HashSet<>();
        released = new LinkedList<>();
        max = maxNumbers;
        curNum = 0;
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(!released.isEmpty()){
            int res = released.poll();
            used.add(res);
            return res;
        }  
        else if(used.size() == max)    return -1;
        else{
            int res = curNum;
            used.add(res);
            curNum++;
            return res;
        }
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !used.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(used.contains(number)){
            used.remove(number);
            released.add(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */