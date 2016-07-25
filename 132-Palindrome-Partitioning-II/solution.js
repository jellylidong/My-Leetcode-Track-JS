/**
 * @param {string} s
 * @return {number}
 */
var minCut = function(s) {
    
    //To better understand this problem, 
    //try test case aaaa and caaaa
    
    var count = []; //count[i] means the min cut of s.substring(0, i+1)
    for(let i = 0; i < s.length; i++)
        count[i] = i;
    
    var len = s.length;
    for(let i = 0; i < len; i++){
        //assume the pal is odd length, then use s[i] as the mid char of the pal
        //update the count while s[i-x..i..i+x] is pal
        let offset = 0;
        while(i-offset >= 0 && i+offset < len && s[i-offset] == s[i+offset]){
            count[i+offset] = Math.min(count[i+offset], i-offset === 0? 0:count[i-offset-1]+1);
            offset++;
        }
        
        //assume the pal is even length, then use s[i] as the end of left half of the pal
        //update the count while s[i-x..i,i+1..i+1+x] is pal
        offset = 0;
        while(i-offset >= 0 && i+1+offset < len && s[i-offset] == s[i+1+offset]){
            count[i+1+offset] = Math.min(count[i+1+offset], i-offset === 0? 0:count[i-offset-1]+1);
            offset++;
        }
    }
    
    return count[len-1];
};