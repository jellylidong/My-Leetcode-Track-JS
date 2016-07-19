# 329. Longest Increasing Path in a Matrix

[Original Page](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/)

Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

**Example 1:**

<pre>nums = [
  [<font color="red">9</font>,9,4],
  [<font color="red">6</font>,6,8],
  [<font color="red">2</font>,<font color="red">1</font>,1]
]
</pre>

Return `4`  
The longest increasing path is `[1, 2, 6, 9]`.

**Example 2:**

<pre>nums = [
  [<font color="red">3</font>,<font color="red">4</font>,<font color="red">5</font>],
  [3,2,<font color="red">6</font>],
  [2,2,1]
]
</pre>

Return `4`  
The longest increasing path is `[3, 4, 5, 6]`. Moving diagonally is not allowed.

**Credits:**  
Special thanks to [@dietpepsi](https://leetcode.com/discuss/user/dietpepsi) for adding this problem and creating all test cases.

<div>

<div id="company_tags" class="btn btn-xs btn-warning">Show Company Tags</div>

<span class="hidebutton">[Google](/company/google/)</span></div>

<div>

<div id="tags" class="btn btn-xs btn-warning">Show Tags</div>

<span class="hidebutton">[Depth-first Search](/tag/depth-first-search/) [Topological Sort](/tag/topological-sort/) [Memoization](/tag/memoization/)</span></div>