/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int ans = -1;
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(i != j){
                    if(knows(j, i) && !knows(i, j))
                        count++;
                    if(count == n-1){
                        ans = i;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}