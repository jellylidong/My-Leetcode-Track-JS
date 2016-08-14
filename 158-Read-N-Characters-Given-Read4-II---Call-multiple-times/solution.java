/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    
    char[] tmpBuf = new char[4];
    int readCount = 0;
    int tmpBufId = 0; 
     
    public int read(char[] buf, int n) {
        //the read4(char[] buf) reads 4 chars from a file and stores it to the buf
        //and it returns the number of chars it reads
        
        int bufId = 0;
        
        while(bufId < n){
            if(tmpBufId == 0)
                readCount = read4(tmpBuf);
            if(readCount == 0)  break;
            
            while(bufId < n && tmpBufId < readCount){
                buf[bufId] = tmpBuf[tmpBufId];
                bufId++;
                tmpBufId++;
            }
            if(tmpBufId == readCount)
                tmpBufId = 0;
        }
        
        return bufId;
    }
}