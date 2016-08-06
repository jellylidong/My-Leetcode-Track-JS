public class Solution {
    public String rearrangeString(String str, int k) {
        int[] count = new int[26];
        int[] position = new int[26];
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            count[c-'a']++;
        }
        
        String res = helper(count, position, k, str.length());
        
        return res.length() == str.length()? res:"";
    }
    
    public String helper(int[] count, int[] position, int k, int len){
        StringBuilder sb = new StringBuilder();
        PriorityQueue<myChar> pq = new PriorityQueue<>(len, new myCharCompartor());
        for(int i = 0; i < count.length; i++){
            pq.offer(new myChar((char)(i+'a'), count[i], position[i]));
        }
        
        for(int i = 0; i < len; i++){
            int max = 0;
            
            Stack<myChar> backup = new Stack<>();
            
            // for(int j = 0; j < count.length; j++){
            //     if(count[j] > 0 && count[j] > max && i >= position[j]){
            //         max = count[j];
            //         index = j;
            //     }
            // }
            
            myChar toChange = null;
            while(!pq.isEmpty()){
                myChar curChar = pq.poll();
                if(curChar.count > 0 && curChar.count > max && i >= curChar.nextPos){
                    max = curChar.count;
                    toChange = curChar;
                    break;
                }
                else backup.push(curChar);
                
            }
            // if(index == -1) return sb.toString();
            // count[index]--;
            // position[index] = i+k;
            // sb.append((char)('a'+index));
            
            if(toChange == null)    return sb.toString();
            toChange.count--;
            toChange.nextPos = i+k;
            sb.append(toChange.c);
            if(toChange.count != 0) backup.push(toChange);
            while(!backup.isEmpty()) pq.offer(backup.pop());
        }
        return sb.toString();
    }
    
    public class myChar{
        char c;
        int count;
        int nextPos;
        myChar(char c, int count, int nextPos){
            this.c = c;
            this.count = count;
            this.nextPos = nextPos;
        }
    }
    
    public class myCharCompartor implements Comparator<myChar>{
        @Override
        public int compare(myChar c1, myChar c2){
            if(c1.count != c2.count)    return -(c1.count - c2.count);
            else    return -(c1.nextPos - c2.nextPos);
        }
    }
}