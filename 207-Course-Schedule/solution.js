/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {boolean}
 */
var canFinish = function(n, pre) {
    //seem LC can not use require, it can not use hashmap
    var HashMap = require("hashmap");
    var preCount = new HashMap(); //count of pre-req
    var followList = new HashMap();
    for(var i = 0; i < n; i++){
        preCount.set(i, 0);
        followList.set(i, []);
    }
    for( i = 0; i < pre.length; i++){
        var course = pre[i][0];
        var req = pre[i][1];
        preCount.set(course, preCount.get(course)+1);
        followList.get(req).push(course);
    }
    console.log(preCount);
    console.log(followList);
    var q = [];
    preCount.forEach(function(value, key){
        if(value === 0) q.push(key);
    });
    while(q.length > 0){
        var size = q.length;
        for(i = 0; i < size; i++){
            course = q.shift();
            n--;
            var list = followList.get(course);
            for(i = 0; i < list.length; i++){
                preCount.set(list[i], preCount.get(list[i])-1);
                if(preCount.get(list[i]) === 0)
                    q.push(list[i]);
            }
        }
    }
    
    return n === 0;
};