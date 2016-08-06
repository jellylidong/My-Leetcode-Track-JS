public class Solution {
    public String rearrangeString(String str, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(!map.containsKey(c)) map.put(c, 0);
            map.put(c, map.get(c)+1);
        }
        
        Queue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(26, new Comparator<Map.Entry<Character, Integer>>(){
            @Override
            public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2){
                return -(e1.getValue() - e2.getValue());
            }
        });
        Queue<Map.Entry<Character, Integer>> waitQ = new LinkedList<>();
        
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> curEntry = pq.poll();
            waitQ.offer(curEntry);
            sb.append(curEntry.getKey());
            
            if(waitQ.size() < k)    continue;
            else{
                Map.Entry<Character, Integer> nextEntry = waitQ.poll();
                nextEntry.setValue(nextEntry.getValue()-1);
                if(nextEntry.getValue() > 0)    pq.offer(nextEntry);
            }
        }
        
        return sb.length() == str.length()? sb.toString():"";
    }
}