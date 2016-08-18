# 281. Zigzag Iterator

[Original Page](https://leetcode.com/problems/zigzag-iterator/)

Given two 1d vectors, implement an iterator to return their elements alternately.

For example, given two 1d vectors:

<pre>v1 = [1, 2]
v2 = [3, 4, 5, 6]
</pre>

By calling _next_ repeatedly until _hasNext_ returns `false`, the order of elements returned by _next_ should be: `[1, 3, 2, 4, 5, 6]`.

**Follow up**: What if you are given `k` 1d vectors? How well can your code be extended to such cases?

**<u>Clarification for the follow up question - <font color="red">Update (2015-09-18):</font></u>**  
The "Zigzag" order is not clearly defined and is ambiguous for `k > 2` cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

<pre>[1,2,3]
[4,5,6,7]
[8,9]
</pre>

It should return `[1,4,8,2,5,9,3,6,7]`.

<div>

<div id="company_tags" class="btn btn-xs btn-warning">Show Company Tags</div>

<span class="hidebutton">[Google](/company/google/)</span></div>

<div>

<div id="tags" class="btn btn-xs btn-warning">Show Tags</div>

<span class="hidebutton">[Design](/tag/design/)</span></div>

<div>

<div id="similar" class="btn btn-xs btn-warning">Show Similar Problems</div>

<span class="hidebutton">[(M) Binary Search Tree Iterator](/problems/binary-search-tree-iterator/) [(M) Flatten 2D Vector](/problems/flatten-2d-vector/) [(M) Peeking Iterator](/problems/peeking-iterator/) [(M) Flatten Nested List Iterator](/problems/flatten-nested-list-iterator/)</span></div>