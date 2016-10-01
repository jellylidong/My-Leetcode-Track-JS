import java.math.BigInteger;
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if(len == 0)    return ans;
        StringBuilder beginSb = new StringBuilder();
        StringBuilder endSb = new StringBuilder();
        for(int i = 0; i < len; i++){
            beginSb.append(0);
            endSb.append(1);
        }
        
        BigInteger lo = new BigInteger(beginSb.toString(), 2);
        BigInteger hi = new BigInteger(endSb.toString(), 2);
        
//        System.out.println("hi: " + hi);
        
        while(lo.compareTo(hi) <= 0){
            String bits = lo.toString(2);
            System.out.println(bits);
            List<Integer> list = new ArrayList<>();
            for(int i = bits.length()-1; i >= 0; i--){
                if(bits.charAt(i) == '1')
                    list.add(nums[i+len-bits.length()]);
            }
            ans.add(list);
            lo = lo.add(new BigInteger("1"));
//            System.out.println(lo);
        }
        return ans;
    }
}