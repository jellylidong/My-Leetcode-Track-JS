public class NumArray {
    // segmentTree root;
    // public NumArray(int[] nums) {
    //     if(nums.length == 0)    return;
    //     root = genTree(nums, 0, nums.length-1);
    // }

    // void update(int i, int val) {
    //     updateTree(root, i, val);
    // }

    // public int sumRange(int i, int j) {
    //     return sumRange(root, i, j);
    // }
    
    // public class segmentTree{
    //     segmentTree left = null;
    //     segmentTree right = null;
    //     int lo, hi, sum;
    //     segmentTree(int lo, int hi){
    //         this.lo = lo;
    //         this.hi = hi;
    //         this.sum = 0;
    //     }
    // }
    
    // public segmentTree genTree(int[] nums, int lo, int hi){
    //     segmentTree root = new segmentTree(lo, hi);
    //     if(lo == hi)    root.sum = nums[lo];
    //     else{
    //         int mid = lo + (hi-lo)/2;
    //         root.left = genTree(nums, lo, mid);
    //         root.right = genTree(nums, mid+1, hi);
    //         root.sum = root.left.sum + root.right.sum;
    //     }
    //     return root;
    // }
    
    // public void updateTree(segmentTree root, int pos, int val){
    //     int lo = root.lo;
    //     int hi = root.hi;
    //     if(lo == hi) root.sum = val;
    //     else{
    //         int mid = lo + (hi-lo)/2;
    //         if(pos <= mid)  updateTree(root.left, pos, val);
    //         else    updateTree(root.right, pos, val);
    //         root.sum = root.left.sum + root.right.sum;
    //     }
    // }
    
    // public int sumRange(segmentTree root, int lo, int hi){
    //     if(lo == root.lo && hi == root.hi)  return root.sum;
    //     else{
    //         int mid = root.lo + (root.hi-root.lo)/2;
    //         if(hi <= mid)   return sumRange(root.left, lo, hi);
    //         else if(lo >= mid+1)  return sumRange(root.right, lo, hi);
    //         else    return sumRange(root.left, lo, mid) + sumRange(root.right, mid+1, hi);
    //     }
    // }
    
    
    
    
    
    
    segmentTree root;
    public NumArray(int[] nums) {
        this.root = genTree(nums, 0, nums.length-1);
    }

    void update(int i, int val) {
        update(root, i, val);
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    
    class segmentTree{
        int lo, hi; //range of nums that will be used to build current tree node
        segmentTree left, right;
        int sum;
        
        segmentTree(int[] nums, int lo, int hi){
            this.lo = lo;
            this.hi = hi;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }    
    
    public segmentTree genTree(int[] nums, int lo, int hi){
        if(lo > hi)
            return null;
        else{
            segmentTree root = new segmentTree(nums, lo, hi);
            if(lo == hi){
                root.sum = nums[lo];
            }
            else{
                int mid = lo + (hi-lo)/2;
                root.left = genTree(nums, lo, mid);
                root.right = genTree(nums, mid+1, hi);
                root.sum = root.left.sum + root.right.sum;
            }
            return root;
        }
    }
    
    public void update(segmentTree root, int pos, int val){
        if(root.lo == root.hi)
            root.sum = val;
        else{
            int lo = root.lo;
            int hi = root.hi;
            int mid = lo + (hi-lo)/2;
            if(pos <= mid)
                update(root.left, pos, val);
            else
                update(root.right, pos, val);
                
            root.sum = root.left.sum + root.right.sum;
        }
    }
    
    public int sumRange(segmentTree root, int lo, int hi){
        if(root.lo == lo && root.hi == hi)
            return root.sum;
            
        else{
            int mid = root.lo + (root.hi-root.lo)/2;
            if(hi <= mid)
                return sumRange(root.left, lo, hi);
            else if(lo >= mid+1)
                return sumRange(root.right, lo, hi);
            else
                return sumRange(root.left, lo, mid) + sumRange(root.right, mid+1, hi);
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);