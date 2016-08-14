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
                search(board, visited, i, j, root, ansSet);
            }
        }
        
        ans.addAll(ansSet);
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
    
    public void search(char[][] board, boolean[][] visited, int i, int j, Trie cur, HashSet<String> ansSet){
        if(cur == null)    return;
        if(cur.isStr){
            cur.isStr = false;
            ansSet.add(cur.str);
        }
        
        if(i < 0 || i == board.length || j < 0 || j == board[0].length) return;
        if(visited[i][j])   return;
        
        
        
        visited[i][j] = true;
        search(board, visited, i-1, j, cur.curChar[board[i][j]-'a'], ansSet);
        search(board, visited, i+1, j, cur.curChar[board[i][j]-'a'], ansSet);
        search(board, visited, i, j-1, cur.curChar[board[i][j]-'a'], ansSet);
        search(board, visited, i, j+1, cur.curChar[board[i][j]-'a'], ansSet);
        visited[i][j] = false;
    }
}