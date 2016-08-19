/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int ans = 0;
        
        for(int i = 1; i <= n-1; i++){
            if(knows(ans, i))
                ans = i; //once we find the celebrity, since all people knows it, so it won't change
        }
        
        //but for case 0 does not know 1; 1 does not know 0
        //there is no celebrity actually, so we need to check if it's a real celebrity
        for(int i = 0; i < n; i++){
            if(i != ans){
                if(knows(ans, i) || !knows(i, ans))
                    return -1;
            }
        }
        
        return ans;
        
    }
}