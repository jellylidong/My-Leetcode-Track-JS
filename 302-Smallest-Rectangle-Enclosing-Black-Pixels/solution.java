public class Solution {
    int left, right;
    int up, down;
    public int minArea(char[][] image, int x, int y) {
        left = right = x;
        up = down = y;
        traverse(image, x, y);
        return (right-left+1)*(down-up+1);
    }
    
    public void traverse(char[][] image, int x, int y){
        if(x < 0 || x == image.length)  return;
        if(y < 0 || y == image[0].length)   return;
        if(image[x][y] == '0' || image[x][y] == 'b')    return;
        left = Math.min(left, x);
        right = Math.max(right, x);
        up = Math.min(up, y);
        down = Math.max(down, y);
        image[x][y] = 'b';
        
        traverse(image, x-1, y);
        traverse(image, x+1, y);
        traverse(image, x, y-1);
        traverse(image, x, y+1);
    }
}