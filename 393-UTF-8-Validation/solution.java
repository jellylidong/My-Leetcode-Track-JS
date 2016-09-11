public class Solution {
    public boolean validUtf8(int[] data) {
        int i = 0;
        while(i < data.length){
            if(data[i] > 255)   return false;
            String cur = toBin(data[i]);
            int nOne = 0;
            int k = 0;
            for(; k < cur.length(); k++){
                if(cur.charAt(k) == '1')    nOne++;
                else break;
            }
            // System.out.println("i " + i + " k "+ k);
            if(nOne == 0){
                i++;
                continue;
            }
            else{
                // int nZero = 0;
                // for(; k < cur.length(); k++){
                //     if(cur.charAt(k) == '0') nZero++;
                //     else break;
                // }
                // if(nZero < nOne+1)    {
                //     // System.out.println("num " + cur + " 1111" + " " + "zero " + nZero + " " + "one " + nOne);
                //     return false;
                    
                // }
                if(nOne > 4 || nOne == 1)    return false;
                if(k == cur.length() || cur.charAt(k) != '0')   return false;
                for(int j = 0; j < nOne-1; j++){
                    i++;
                    if(i == data.length) {   
                        // System.out.println("2222");
                        return false;}
                    cur = toBin(data[i]);
                    if(!cur.startsWith("10"))   {
                        // System.out.println("3333");
                        return false;}
                }
                i++;
            }
        }
        return true;
        
    }
    
    public String toBin(int n){
        String ans = "";
        while(ans.length() < 8){
            ans = (n%2) + ans;
            n /= 2;
        }
        return ans;
    }
}