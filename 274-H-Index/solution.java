public class Solution {
    public int hIndex(int[] citations) {
        // Arrays.sort(citations);
        // int h = 0;
        // for(int i = 0; i < citations.length; i++){
        //     if(citations[i] >= citations.length-i){
        //         // h = Math.max(h, citations.length-i);
        //         h = citations.length-i;
        //         break;
        //     }
        // }
        
        // return h;
        
        int len = citations.length;
        int[] count = new int[len+1];
        //count[i] means the count of paper is cited i times
        //count[len] means the count of paper is cited >= len times
        
        for(int i= 0; i < len; i++){
            if(citations[i] >= len) count[len]++;
            else    count[citations[i]]++;
        }
        
        int sum = 0;
        for(int i = len; i >= 0; i--){
            sum += count[i];
            if(sum >= i)   return i;
        }
        
        return 0;
    }
}