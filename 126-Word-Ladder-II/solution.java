public class Solution {
    public List<List<String>> findLadders(String begin, String end, Set<String> wordList) {
        
        //level order BFS to build a graph that contains the shorted path from begin to end
		
		HashMap<String, List<String>> graph = new HashMap<>();
		//key: string, val:candidate string
		Queue<String> q = new LinkedList<>();
		q.offer(begin);
		wordList.remove(begin);
		wordList.add(end);
		
		
		boolean found = false;
		while(!q.isEmpty() && !found){
			int size = q.size();
			HashSet<String> visited = new HashSet<>();
			for(int i = 0; i < size; i++){
				String cur = q.poll();
				graph.put(cur, new ArrayList<String>());
				char[] cs = cur.toCharArray();
				for(int j = 0; j < cs.length; j++){
					char tmp = cs[j];
					for(char c = 'a'; c <= 'z'; c++){
						if(c != tmp){
							cs[j] = c;;
							String newStr = new String(cs);
							if(wordList.contains(newStr)){
								if(!visited.contains(newStr)){
									q.offer(newStr);
									visited.add(newStr);
								}
								graph.get(cur).add(newStr);
								if(newStr.equals(end))	found = true;
							}
							
						}
					}
					cs[j] = tmp;
				}
			}
			wordList.removeAll(visited);
		}
		
		//print the map, used for debug
//		for(String key: graph.keySet()){
//			System.out.print(key + ":");
//			for(String s: graph.get(key)){
//				System.out.print(s + " ");
//			}
//			System.out.println();
//		}
		
		List<List<String>> ans = new ArrayList<>();
		genList(begin, end, graph, ans, new ArrayList<String>());
		return ans;
    }
    
    private void genList(String begin, String end, HashMap<String, List<String>> graph, List<List<String>> ans, ArrayList<String> curList){
		
		curList.add(begin);
		if(begin.equals(end)){
			ans.add(new ArrayList<String>(curList));
		}
		else if(graph.containsKey(begin)){
			for(String next: graph.get(begin)){
				genList(next, end, graph, ans, curList);
			}
		}
		curList.remove(curList.size()-1);
	}
}