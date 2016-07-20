/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {boolean}
 */
var canFinish = function(n, pre) {
    var preCount = new Map();
    var followList = new Map();
    for(let i = 0; i < n; i++){
        preCount.set(i, 0);
        followList.set(i, []);
    }
    
    for(let i = 0; i < pre.length; i++){
        let course = pre[i][0];
        let preReq = pre[i][1];
        preCount.set(course, preCount.get(course)+1);
        followList.get(preReq).push(course);
    }
    // console.log(followList);
    var q = [];
    // console.log(preCount);
    preCount.forEach(function(value, key){
        if(value === 0) q.push(key);
    })
    
    while(q.length > 0){
        let size = q.length;
        n -= size;
        for(let i = 0; i < size; i++){
            let list = followList.get(q.shift());
            for(let j = 0; j < list.length; j++){
                preCount.set(list[j], preCount.get(list[j])-1);
                if(preCount.get(list[j]) === 0)
                    q.push(list[j]);
            }
        }
        // console.log(preCount);
    }
    console.log(n)
    return n === 0;
    
};