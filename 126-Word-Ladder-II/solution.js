/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {Set} wordList
 *   Note: wordList is a Set object, see:
 *   https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Set
 * @return {string[][]}
 */
var findLadders = function(beginWord, endWord, wordList) {
    
    var buildGraph = function(s1, s2, dict, graph, genChild){
        if(s1.size === 0)   return;
        if(s1.size > s2.size){
            buildGraph(s2, s1, dict, graph, !genChild);
            return;
        }
        s1.forEach(function(value){dict.delete(value)});
        s2.forEach(function(value){dict.delete(value)});
        
        var crossed = false;
        var newSet = new Set();
        s1.forEach(function(str){
            var cs = str.split('');
            for(let i = 0; i < cs.length; i++){
                var pre = cs[i];
                for(let c = 97; c <= 97+25; c++){
                    cs[i] = String.fromCharCode(c);
                    var newStr = cs.join('');
                    var key = genChild? str: newStr;
                    var val = genChild? newStr: str;
                    
                    var list = graph.has(key)? graph.get(key):[];
                    
                    if(s2.has(newStr)){
                        list.push(val);
                        graph.set(key, list);
                        crossed = true;
                    }
                    if(!crossed && dict.has(newStr)){
                        list.push(val);
                        graph.set(key, list);
                        newSet.add(newStr);
                    }
                }
                cs[i] = pre;
            }
        });
        if(!crossed)    buildGraph(s2, newSet, dict, graph, !genChild);
    }
    
    var genList = function(graph, begin, end, ans, sol){
        if(begin === end){
            var newSol = [];
            sol.forEach(function(value){
                newSol.push(value);
            })
            ans.push(newSol);
        }
        else if(graph.has(begin)){
            graph.get(begin).forEach(function(s){
                sol.push(s);
                genList(graph, s, end, ans, sol);
                sol.pop();
            })
        }
    }
    
    var s1 = new Set();
    var s2 = new Set();
    s1.add(beginWord);
    s2.add(endWord);
    var graph = new Map(); // key: word, value:list of following words of key that are still in dict
    buildGraph(s1, s2, wordList, graph, true);
    var ans = [];
    var sol = [];
    sol.push(beginWord);
    genList(graph, beginWord, endWord, ans, sol);
    
    return ans;
};