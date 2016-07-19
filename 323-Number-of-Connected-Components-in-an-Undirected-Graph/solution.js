/**
 * @param {number} n
 * @param {number[][]} edges
 * @return {number}
 */
var countComponents = function(n, edges) {
    var UF = function(n){
        this.amount = n;
        this.roots = [];
        for(let i = 0; i < n; i++)
            this.roots.push(i);
        this.find = function(p){
            while(p !== this.roots[p]){
                var father = this.roots[p];
                this.roots[p] = this.roots[father];
                p = this.roots[p];
            }
            return p;
        }
        this.connect = function(p, q){
            var r1 = this.find(p);
            var r2 = this.find(q);
            if(r1 !== r2){
                if(r1 < r2) this.roots[r1] = r2;
                else    this.roots[r2] = r1;
                this.amount--;
            }
        }
    }
    
    var uf = new UF(n);
    for(let i = 0; i < edges.length; i++){
        var p = edges[i][0];
        var q = edges[i][1];
        uf.connect(p, q);
    }
    return uf.amount;
};