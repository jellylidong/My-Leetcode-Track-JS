# 239. Sliding Window Maximum

[Original Page](https://leetcode.com/problems/sliding-window-maximum/)

Given an array _nums_, there is a sliding window of size _k_ which is moving from the very left of the array to the very right. You can only see the _k_ numbers in the window. Each time the sliding window moves right by one position.

For example,  
Given _nums_ = `[1,3,-1,-3,5,3,6,7]`, and _k_ = 3.

<pre>Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
</pre>

Therefore, return the max sliding window as `[3,3,5,5,6,7]`.

**Note:**  
You may assume _k_ is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

**Follow up:**  
Could you solve it in linear time?

**Hint:**

[Show Hint](#)

1.  How about using a data structure such as deque (double-ended queue)?[Show More Hint](#)
2.  The queue size need not be the same as the window’s size.[Show More Hint](#)
3.  Remove redundant elements and the queue should store only elements that need to be considered.

<div>

<div id="company_tags" class="btn btn-xs btn-warning">Show Company Tags</div>

<span class="hidebutton">[Amazon](/company/amazon/) [Google](/company/google/) [Zenefits](/company/zenefits/)</span></div>

<div>

<div id="tags" class="btn btn-xs btn-warning">Show Tags</div>

<span class="hidebutton">[Heap](/tag/heap/)</span></div>

<div>

<div id="similar" class="btn btn-xs btn-warning">Show Similar Problems</div>

<span class="hidebutton">[(H) Minimum Window Substring](/problems/minimum-window-substring/) [(E) Min Stack](/problems/min-stack/) [(H) Longest Substring with At Most Two Distinct Characters](/problems/longest-substring-with-at-most-two-distinct-characters/) [(H) Paint House II](/problems/paint-house-ii/)</span></div>