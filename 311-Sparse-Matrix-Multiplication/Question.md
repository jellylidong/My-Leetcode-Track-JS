# 311. Sparse Matrix Multiplication

[Original Page](https://leetcode.com/problems/sparse-matrix-multiplication/)

Given two [sparse matrices](https://en.wikipedia.org/wiki/Sparse_matrix) **A** and **B**, return the result of **AB**.

You may assume that **A**'s column number is equal to **B**'s row number.

**Example:**

<pre>**A** = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

**B** = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]

     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
**AB** = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
</pre>

<div>

<div id="company_tags" class="btn btn-xs btn-warning">Show Company Tags</div>

<span class="hidebutton">[LinkedIn](/company/linkedin/) [Facebook](/company/facebook/)</span></div>

<div>

<div id="tags" class="btn btn-xs btn-warning">Show Tags</div>

<span class="hidebutton">[Hash Table](/tag/hash-table/)</span></div>