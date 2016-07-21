/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
var isScramble = function(s1, s2) {
    var map = new Map();
    var helper = function(s1, s2){
        if(s1 === s2)   return true;
        if(s1.length !== s2.length) return false;
        let key = s1+"+"+s2;
        if(map.has(key))  return map.get(key);
        
        var count = [];
        for(let i = 0; i < 26; i++)
            count.push(0);
        for(let j =0; j < s1.length; j++){
            count[s1.charCodeAt(j)-'a'.charCodeAt(0)]++;
            count[s2.charCodeAt(j)-'a'.charCodeAt(0)]--;
        }
        for(let i = 0; i < 26; i++){
            if(count[i] !== 0){
                map.set(key, false);
                return false;
            }
        }
        
        for(let i = 1; i < s1.length; i++){
            var s11 = s1.substring(0, i);
            var s12 = s1.substring(i);
            var s21 = s2.substring(0, i);
            var s22 = s2.substring(i);
            var s23 = s2.substring(0, s2.length-i);
            var s24 = s2.substring(s2.length-i);
            
            var res = (helper(s11, s21) && helper(s12, s22)) ||
                      (helper(s11, s22) && helper(s12, s21)) ||
                      (helper(s11, s23) && helper(s12, s24)) ||
                      (helper(s11, s24) && helper(s12, s23));
            if(res){
                map.set(key, res);
                return res;
            }
        }
        map.set(key, false);
        return false;
    }
    
    return helper(s1, s2);
};