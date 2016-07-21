/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalRectangle = function(matrix) {
    var m = matrix.length;
    if(m === 0) return 0;
    var n = matrix[0].length;
    if(n === 0) return 0;
    
    var left = [], right = [], height = [];
    for(let i = 0; i < n; i++){
        left.push(0);
        right.push(n-1);
        height.push(0);
    }
    
    var max = 0;
    for(let i = 0; i < m; i++){
        for(let j = 0; j < n; j++){
            if(matrix[i][j] === '1') height[j]++;
            else    height[j] = 0;
        }
        
        let curLeft = 0;
        for(let j = 0; j < n; j++){
            if(matrix[i][j] === '1') left[j] = Math.max(left[j], curLeft);
            else    {left[j] = 0; curLeft = j+1;}
        }
        
        let curRight = n-1;
        for(let j = n-1; j >= 0; j--){
            if(matrix[i][j] === '1') right[j] = Math.min(right[j], curRight);
            else    {right[j] = n-1; curRight = j-1;}
        }
        
        for(let j = 0; j < n; j++){
            max = Math.max(max, (right[j]-left[j]+1)*height[j]);
        }
    }
    
    return max;
};