public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        int maxSize = 0;
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
            
            List<Integer> curList = new ArrayList<>();
            curList.add(nums[i]);
            
            List<Integer> preList = new ArrayList<>();
            int preMaxSize = 0;
            for(int j = i-1; j >= 0; j--){
                if(nums[i]%nums[j] == 0 && preMaxSize < map.get(nums[j]).size()){
                    preList = map.get(nums[j]);
                    preMaxSize = preList.size();
                }
            }
            curList.addAll(preList);
            map.put(nums[i], curList);
            if(curList.size() > maxSize){
                maxSize = curList.size();
                ans = curList;
            }
        }
        
        return ans;
    }
}