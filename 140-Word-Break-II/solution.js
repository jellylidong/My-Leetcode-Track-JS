/**
 * @param {string} s
 * @param {set<string>} wordDict
 *   Note: wordDict is a Set object, see:
 *   https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Set
 * @return {string[]}
 */
var wordBreak = function(s, wordDict) {
    var map = new Map();
    //key: str
    //val: lists of wordBreak(str)
    
    var helper = function(s, dict, map){
        if(map.has(s))  return map.get(s);
        
        var curList = [];
        if(dict.has(s)) curList.push(s);
        dict.forEach(function(str){
            if(s.startsWith(str)){
                var nextList = helper(s.substring(str.length), dict, map);
                for(let i = 0; i < nextList.length; i++)
                    curList.push(str + " " + nextList[i]);
            }
        });
        
        map.set(s, curList);
        return curList;
    }
    
    return helper(s, wordDict, map);
    
};