public class Solution {
    public boolean isRectangleCover(int[][] rect) {
        
        // int leftY = rect[0][0];
        // int leftX = rect[0][1];
        // int rightY = rect[0][2];
        // int rightX = rect[0][3];
        
        // for(int[] cur: rect){
        //     leftY = Math.min(leftY, cur[0]);
        //     leftX = Math.min(leftX, cur[1]);
        //     rightY = Math.max(rightY, cur[2]);
        //     rightX = Math.max(rightX, cur[3]);
        // }
        
        // // if(rightY-leftY != rightX - leftX)  return false;
        // int h = rightY - leftY;
        // int w = rightX - leftX;
        // int area = w * h;
        // BitSet bitset = new BitSet(area);
        
        // for(int[] cur: rect){
        //     for(int y = cur[0]+1; y <= cur[2]; y++){
        //         for(int x = cur[1]+1; x <= cur[3]; x++){
        //             int position = (y-(leftY+1))*w + (x-(leftX+1));
        //             if(bitset.get(position))   return false;
        //             bitset.set(position);
        //         }
        //     }
            
        // }
        
        // for(int i = 0; i < area; i++){
        //     if(!bitset.get(i))  return false;
        // }
        // return true;
        
        
        
        //!!!!!!!!!
        //bitset should work, but it takes too much memory, not AC
        
        int leftY = rect[0][0];
        int leftX = rect[0][1];
        int rightY = rect[0][2];
        int rightX = rect[0][3];
        
        HashSet<String> set = new HashSet<>();
        int area = 0;
        for(int[] cur: rect){
            leftY = Math.min(leftY, cur[0]);
            leftX = Math.min(leftX, cur[1]);
            rightY = Math.max(rightY, cur[2]);
            rightX = Math.max(rightX, cur[3]);
            
            area += (cur[3] - cur[1]) * (cur[2] - cur[0]);
            
            String s1 = cur[0] + " " + cur[1];
            String s2 = cur[0] + " " + cur[3];
            String s3 = cur[2] + " " + cur[1];
            String s4 = cur[2] + " " + cur[3];
            
            if(set.contains(s1))    set.remove(s1);
            else set.add(s1);
            
            if(set.contains(s2))    set.remove(s2);
            else set.add(s2);
            
            if(set.contains(s3))    set.remove(s3);
            else set.add(s3);
            
            if(set.contains(s4))    set.remove(s4);
            else set.add(s4);

        }
        
        
        if(!set.contains(leftY+" "+leftX) || !set.contains(leftY+" "+rightX) ||
           !set.contains(rightY+" "+leftX) || !set.contains(rightY+" "+rightX)) 
           return false;
           
        //only the most outter four corners should be left in the set, 
        //otherwise there is a overlap
        if(set.size() > 4)  return false;
        
        return area == (rightY-leftY)*(rightX-leftX);
        
    }
}