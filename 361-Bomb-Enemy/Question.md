# 361. Bomb Enemy

[Original Page](https://leetcode.com/problems/bomb-enemy/)

Given a 2D grid, each cell is either a wall `'W'`, an enemy `'E'` or empty `'0'` (the number zero), return the maximum enemies you can kill using one bomb.  
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.  
Note that you can only put the bomb at an empty cell.

**Example:**  

<pre>For the given grid

0 E 0 0
E 0 W E
0 E 0 0

return 3\. (Placing a bomb at (1,1) kills 3 enemies)
</pre>

**Credits:**  
Special thanks to [@memoryless](https://discuss.leetcode.com/user/memoryless) for adding this problem and creating all test cases.

<div>

<div id="company_tags" class="btn btn-xs btn-warning">Show Company Tags</div>

<span class="hidebutton">[Google](/company/google/)</span></div>

<div>

<div id="tags" class="btn btn-xs btn-warning">Show Tags</div>

<span class="hidebutton">[Dynamic Programming](/tag/dynamic-programming/)</span></div>