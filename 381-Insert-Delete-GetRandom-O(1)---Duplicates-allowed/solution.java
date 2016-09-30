public class RandomizedCollection {

    /** Initialize your data structure here. */
    HashMap<Integer, HashSet<Integer>> map;
    List<Integer> list;
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = true;
        if(map.containsKey(val))    res = false;
        else map.put(val, new HashSet<Integer>());
        
        map.get(val).add(list.size());
        list.add(val);
        
        return res;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean res = false;
        if(!map.containsKey(val))   return res;
        else{
           
            int pos = map.get(val).iterator().next();
            map.get(val).remove(pos);
            
            if(pos < list.size()-1){
                int tail = list.get(list.size()-1);
                list.set(pos, tail);
                HashSet<Integer> set = map.get(tail);
                set.add(pos);
                set.remove(list.size()-1);
            }
            
            if(map.get(val).size() == 0)
                map.remove(val);
            list.remove(list.size()-1);
            
            
            return true;
        }   
    }
    
    void print(){
    	for(int n: list){
    		System.out.print(n + " ");
    	}
    	System.out.println();
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
    	double seed = Math.random();
//        System.out.print(" seed: " + seed + " ");
        int idx = (int)(seed*list.size());
        return list.get(idx);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */