# 286. Walls and Gates

[Original Page](https://leetcode.com/problems/walls-and-gates/)

You are given a _m x n_ 2D grid initialized with these three possible values.

1.  `-1` - A wall or an obstacle.
2.  `0` - A gate.
3.  `INF` - Infinity means an empty room. We use the value `2<sup>31</sup> - 1 = 2147483647` to represent `INF` as you may assume that the distance to a gate is less than `2147483647`.

Fill each empty room with the distance to its _nearest_ gate. If it is impossible to reach a gate, it should be filled with `INF`.

For example, given the 2D grid:  

<pre>INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF</pre>

After running your function, the 2D grid should be:  

<pre>  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4</pre>

<div>

<div id="company_tags" class="btn btn-xs btn-warning">Show Company Tags</div>

<span class="hidebutton">[Google](/company/google/) [Facebook](/company/facebook/)</span></div>

<div>

<div id="tags" class="btn btn-xs btn-warning">Show Tags</div>

<span class="hidebutton">[Breadth-first Search](/tag/breadth-first-search/)</span></div>

<div>

<div id="similar" class="btn btn-xs btn-warning">Show Similar Problems</div>

<span class="hidebutton">[(M) Surrounded Regions](/problems/surrounded-regions/) [(M) Number of Islands](/problems/number-of-islands/) [(H) Shortest Distance from All Buildings](/problems/shortest-distance-from-all-buildings/)</span></div>