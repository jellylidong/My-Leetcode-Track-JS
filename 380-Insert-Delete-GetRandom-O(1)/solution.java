public class RandomizedSet {

    /** Initialize your data structure here. */
    List<Integer> list;
    HashMap<Integer, Integer> map;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val, list.size());
            list.add(val);
            return true;
        }
        else    return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        //to make sure remove take O(1), 
        //we first swap the toRm val with the last value of the list
        if(map.containsKey(val)){
            int id1 = map.get(val);
            int val2 = list.get(list.size()-1);
            
            map.put(val2, id1);
            list.set(id1, val2);
            
            map.remove(val);
            list.remove(list.size()-1);
            
            return true;
        }
        else    return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int id = (int)Math.random()*list.size();
        return list.get(id);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */