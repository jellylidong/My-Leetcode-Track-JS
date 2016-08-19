public class Solution {
    public String fractionToDecimal(int n, int d) {
        if(n == 0)  return "0";
        StringBuilder sb = new StringBuilder();
        HashMap<Long, Integer> map = new HashMap<>();
        //key n, value:position in stringbuilder
        if((n > 0 && d < 0) || (n < 0 && d > 0))
            sb.append('-');
            
        long nn = Math.abs((long)n);
        long dd = Math.abs((long)d);
        
        sb.append(nn/dd);
        nn %= dd;
        if(nn != 0) sb.append('.');
        map.put(nn, sb.length());
        
        while(nn != 0){
            nn *= 10;
            sb.append(nn/dd);
            nn %= dd;
            if(map.containsKey(nn)){
                int position = map.get(nn);
                sb.insert(position, '(');
                sb.append(')');
                break;
            }
            map.put(nn, sb.length());
        }
        
        return sb.toString();
    }
}