/**
 * @param {number[][]} matrix
 * @return {number}
 */
var longestIncreasingPath = function(matrix) {
    var m = matrix.length;
    if(m === 0) return 0;
    var n = matrix[0].length;
    if(n === 0) return 0;
    var mem = [];
    for(let i = 0; i < m; i++){
        mem.push([]);
        for(let j = 0; j < n; j++){
            mem[i].push(1);
        }
    }
    
    var update = function(i, j, matrix, mem){
        var cur = matrix[i][j];
        if(i-1 >= 0 && matrix[i-1][j] > cur && mem[i][j]+1 > mem[i-1][j]){
            mem[i-1][j] = mem[i][j]+1;
            update(i-1, j, matrix, mem);
        }
        if(i+1 < m && matrix[i+1][j] > cur && mem[i][j]+1 > mem[i+1][j]){
            mem[i+1][j] = mem[i][j]+1;
            update(i+1, j, matrix, mem);
        }
        if(j-1 >= 0 && matrix[i][j-1] > cur && mem[i][j]+1 > mem[i][j-1]){
            mem[i][j-1] = mem[i][j]+1;
            update(i, j-1, matrix, mem);
        }
        if(j+1 < n && matrix[i][j+1] > cur && mem[i][j]+1 > mem[i][j+1]){
            mem[i][j+1] = mem[i][j]+1;
            update(i, j+1, matrix, mem);
        }
    }
    var max = 0;
    for(let i = 0; i < m; i++){
        for(let j = 0; j < n; j++){
            update(i, j, matrix, mem);
        }
    }
    for(let i = 0; i < m; i++){
        for(let j = 0; j < n; j++){
            max = Math.max(max, mem[i][j]);
        }
    }
    return max;
};