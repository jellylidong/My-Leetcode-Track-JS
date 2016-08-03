# 317. Shortest Distance from All Buildings

[Original Page](https://leetcode.com/problems/shortest-distance-from-all-buildings/)

You want to build a house on an _empty_ land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values **0**, **1** or **2**, where:

*   Each **0** marks an empty land which you can pass by freely.
*   Each **1** marks a building which you cannot pass through.
*   Each **2** marks an obstacle which you cannot pass through.

For example, given three buildings at `(0,0)`, `(0,4)`, `(2,2)`, and an obstacle at `(0,2)`:

<pre>1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0</pre>

The point `(1,2)` is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.

**Note:**  
There will be at least one building. If it is not possible to build such house according to the above rules, return -1.

<div>

<div id="company_tags" class="btn btn-xs btn-warning">Show Company Tags</div>

<span class="hidebutton">[Google](/company/google/) [Zenefits](/company/zenefits/)</span></div>

<div>

<div id="tags" class="btn btn-xs btn-warning">Show Tags</div>

<span class="hidebutton">[Breadth-first Search](/tag/breadth-first-search/)</span></div>

<div>

<div id="similar" class="btn btn-xs btn-warning">Show Similar Problems</div>

<span class="hidebutton">[(M) Walls and Gates](/problems/walls-and-gates/) [(H) Best Meeting Point](/problems/best-meeting-point/)</span></div>