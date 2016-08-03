# 356. Line Reflection

[Original Page](https://leetcode.com/problems/line-reflection/)

Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.

**Example 1:**  

Given _points_ = `[[1,1],[-1,1]]`, return `true`.

**Example 2:**  

Given _points_ = `[[1,1],[-1,-1]]`, return `false`.

**Follow up:**  
Could you do better than O(_n_<sup>2</sup>)?

**Hint:**

[Show Hint](#)

1.  Find the smallest and largest x-value for all points.[Show More Hint](#)
2.  If there is a line then it should be at y = (minX + maxX) / 2.[Show More Hint](#)
3.  For each point, make sure that it has a reflected point in the opposite side.

**Credits:**  
Special thanks to [@memoryless](https://discuss.leetcode.com/user/memoryless) for adding this problem and creating all test cases.

<div>

<div id="company_tags" class="btn btn-xs btn-warning">Show Company Tags</div>

<span class="hidebutton">[Google](/company/google/)</span></div>

<div>

<div id="tags" class="btn btn-xs btn-warning">Show Tags</div>

<span class="hidebutton">[Hash Table](/tag/hash-table/) [Math](/tag/math/)</span></div>

<div>

<div id="similar" class="btn btn-xs btn-warning">Show Similar Problems</div>

<span class="hidebutton">[(H) Max Points on a Line](/problems/max-points-on-a-line/)</span></div>