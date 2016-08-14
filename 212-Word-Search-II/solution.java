public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        int m = board.length;
        if(m == 0)  return ans;
        int n = board[0].length;
        if(n == 0)  return ans;
        
        boolean[][] visited = new boolean[m][n];
        HashSet<String> ansSet = new HashSet<>();
        Trie root = new Trie();
        for(String str: words)  addWord(root, str);
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                search(board, visited, i, j, root, ans);
            }
        }
        
        // ans.addAll(ansSet);
        return ans;
    }
    
    public class Trie{
        boolean isStr;
        String str;
        Trie[] curChar;
        Trie(){
            isStr = false;
            curChar = new Trie[26];
            str = "";
        }
    }
    
    public void addWord(Trie root, String str){
        Trie cur = root;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(cur.curChar[c-'a'] == null)  cur.curChar[c-'a'] = new Trie();
            cur = cur.curChar[c-'a'];
        }
        cur.isStr = true;
        cur.str = str;
    }
    
    // public void search(char[][] board, boolean[][] visited, int i, int j, Trie cur, HashSet<String> ansSet){
    //     if(cur == null)    return;
    //     if(cur.isStr){
            
    //         ansSet.add(cur.str);
    //         cur.isStr = false;
    //         //change cur.isStr to false after we add it to answer so that we don't have to add it again
    //         //once we can avoid add dup, we can add string to list directly instead of HashSet
    //     }
        
    //     if(i < 0 || i == board.length || j < 0 || j == board[0].length) return;
    //     if(visited[i][j])   return;
        
        
        
    //     visited[i][j] = true;
    //     search(board, visited, i-1, j, cur.curChar[board[i][j]-'a'], ansSet);
    //     search(board, visited, i+1, j, cur.curChar[board[i][j]-'a'], ansSet);
    //     search(board, visited, i, j-1, cur.curChar[board[i][j]-'a'], ansSet);
    //     search(board, visited, i, j+1, cur.curChar[board[i][j]-'a'], ansSet);
    //     visited[i][j] = false;
    // }
    
    public void search(char[][] board, boolean[][] visited, int i, int j, Trie cur, List<String> ansSet){
        if(cur == null)    return;
        // if(cur.isStr){
            
        //     ansSet.add(cur.str);
        //     cur.isStr = false;
        //     //change cur.isStr to false after we add it to answer so that we don't have to add it again
        //     //once we can avoid add dup, we can add string to list directly instead of HashSet
        // }
        
        // if(i < 0 || i == board.length || j < 0 || j == board[0].length) return;
        // if(visited[i][j])   return;
        
        
        cur = cur.curChar[board[i][j]-'a'];
        if(cur != null){
            if(cur.isStr){
                ansSet.add(cur.str);
                cur.isStr = false;
            }
            visited[i][j] = true;
            if(i-1 >= 0 && !visited[i-1][j])
                search(board, visited, i-1, j, cur, ansSet);
            if(i+1 < board.length && !visited[i+1][j])
                search(board, visited, i+1, j, cur, ansSet);
            if(j-1 >= 0 && !visited[i][j-1])
                search(board, visited, i, j-1, cur, ansSet);
            if(j+1 < board[0].length && !visited[i][j+1])
                search(board, visited, i, j+1, cur, ansSet);
            visited[i][j] = false;
        }
    }
}