public class Solution {
    public int ladderLength(String begin, String end, Set<String> wordList) {
        int step = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        wordList.remove(begin);
        wordList.add(end);
        
        while(!q.isEmpty()){
            step++;
            int size = q.size();
            HashSet<String> visited = new HashSet<>();
            
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                char[] cs = cur.toCharArray();
                for(int j = 0; j < cs.length; j++){
                    char tmp = cs[j];
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c != tmp){
                            cs[j] = c;
                            String newStr = new String(cs);
                            if(wordList.contains(newStr)){
                                if(!visited.contains(newStr)){
                                    visited.add(newStr);
                                    q.offer(newStr);
                                }
                                if(newStr.equals(end))
                                    return step+1;
                            }
                        }
                    }
                    cs[j] = tmp;
                }
            }
            wordList.removeAll(visited);
        }
        
        return 0;
    }
}