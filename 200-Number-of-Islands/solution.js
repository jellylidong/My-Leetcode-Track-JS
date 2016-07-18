/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    
    //method DFS, like gate and wall problem
    //instead, we if grid[i][j] == 1, label all its neighbor 1 to 0 by DFS
    
    
    var UF = function(grid){
        this.m = grid.length;
        this.n = grid[0].length;
        this.amount = m*n;
        this.arr = [];
        for(var i = 0; i < this.amount; i++)
            this.arr.push(i);
        this.find = function(p){
            while(p != this.arr[p]){
                this.arr[p] = this.arr[this.arr[p]];
                p = this.arr[p];
            }
            return p;
        };
        this.connect = function(p, q){
            var r1 = this.find(p);
            var r2 = this.find(q);
            if(r1 != r2){
                //update father's father, not p or q's father
                if(r1 < r2) {this.arr[r1] = r2;}
                else    {this.arr[r2] = r1;}
                this.amount--;
            }
        };
    };
    var m = grid.length;
    if(m === 0)  return 0;
    var n = grid[0].length;
    if(n === 0) return 0;
    var union = new UF(grid);
    // console.log(union.amount);
    for(var i = 0; i < grid.length; i++){
        for(var j = 0; j < grid[0].length; j++){
            if(grid[i][j] == 1){
                if(i-1 >= 0 && grid[i-1][j] == 1)   union.connect(i*n+j, (i-1)*n+j);
                if(i+1 <  m && grid[i+1][j] == 1)   union.connect(i*n+j, (i+1)*n+j);
                if(j-1 >= 0 && grid[i][j-1] == 1)   union.connect(i*n+j, (i)*n+j-1);
                if(j+1 <  n && grid[i][j+1] == 1)   union.connect(i*n+j, (i)*n+j+1);

            }
            else    union.amount--;
        }
    }
    // console.log(union.arr);
    return union.amount;
    
};