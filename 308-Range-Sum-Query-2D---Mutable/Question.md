# 308. Range Sum Query 2D - Mutable

[Original Page](https://leetcode.com/problems/range-sum-query-2d-mutable/)

Given a 2D matrix _matrix_, find the sum of the elements inside the rectangle defined by its upper left corner (_row_1, _col_1) and lower right corner (_row_2, _col_2).

![Range Sum Query 2D](/static/images/courses/range_sum_query_2d.png)  
<small>The above rectangle (with the red border) is defined by (row1, col1) = **(2, 1)** and (row2, col2) = **(4, 3)**, which contains sum = **8**.</small>

**Example:**  

<pre>Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10
</pre>

**Note:**  

1.  The matrix is only modifiable by the _update_ function.
2.  You may assume the number of calls to _update_ and _sumRegion_ function is distributed evenly.
3.  You may assume that _row_1 ≤ _row_2 and _col_1 ≤ _col_2.

<div>

<div id="company_tags" class="btn btn-xs btn-warning">Show Company Tags</div>

<span class="hidebutton">[Google](/company/google/)</span></div>

<div>

<div id="tags" class="btn btn-xs btn-warning">Show Tags</div>

<span class="hidebutton">[Binary Indexed Tree](/tag/binary-indexed-tree/) [Segment Tree](/tag/segment-tree/)</span></div>

<div>

<div id="similar" class="btn btn-xs btn-warning">Show Similar Problems</div>

<span class="hidebutton">[(M) Range Sum Query 2D - Immutable](/problems/range-sum-query-2d-immutable/) [(M) Range Sum Query - Mutable](/problems/range-sum-query-mutable/)</span></div>