public class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //key: int, val:length of sequence contains this int
        int max = 0;
        for(int num: nums){
            if(!map.containsKey(num)){
                int left = map.containsKey(num-1)? map.get(num-1):0;
                int right= map.containsKey(num+1)? map.get(num+1):0;
                
                int len = left + 1 + right;
                map.put(num, len);
                map.put(num-left, len);
                map.put(num+right, len);
                
                max = Math.max(max, len);
            }
        }
        return max;
    }
}