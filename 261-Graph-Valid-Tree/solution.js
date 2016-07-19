/**
 * @param {number} n
 * @param {number[][]} edges
 * @return {boolean}
 */
var validTree = function(n, edges) {
    //DFS using hashmap can not detect circle like
    //[0,1], [1,2],[0,2]
    //to solve this problem, we use sth similar to UF
    
    var roots = []; //roots[i] means the root of node i
    for(let i = 0; i < n; i++)
        roots.push(i);
    for(let i = 0; i < edges.length; i++){
        var start = edges[i][0];
        var end = edges[i][1];
        
        //find the final root nodes of current start and current end
        while(start != roots[start])
            start = roots[start];
        while(end !=roots[end])
            end = roots[end];
            
        //if current start and current end ends with the same node,
        //it means there is a circle
        //so return false
        if(start === end)
            return false;
        roots[start] = end;
    }
    
    //return true;
    //we can not return true directly, for case 
    //4  [[0,1],[2,3]], there is no circle, but it can not make a graph tree
    //because number of edges may not enough make a true
    //ie there shuold be at least n-1 edges if there are n nodes
    return edges.length >= n-1; // or we can add a judge at the beginning
};