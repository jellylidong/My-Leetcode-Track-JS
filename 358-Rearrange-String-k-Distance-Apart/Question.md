# 358. Rearrange String k Distance Apart

[Original Page](https://leetcode.com/problems/rearrange-string-k-distance-apart/)

Given a non-empty string **str** and an integer **k**, rearrange the string such that the same characters are at least distance **k** from each other.

All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string `""`.

**Example 1:**  

<pre>str = "aabbcc", k = 3

Result: "abcabc"

The same letters are at least distance 3 from each other.
</pre>

**Example 2:**  

<pre>str = "aaabc", k = 3 

Answer: ""

It is not possible to rearrange the string.
</pre>

**Example 3:**  

<pre>str = "aaadbbcc", k = 2

Answer: "abacabcd"

Another possible answer is: "abcabcda"

The same letters are at least distance 2 from each other.
</pre>

**Credits:**  
Special thanks to [@elmirap](https://discuss.leetcode.com/user/elmirap) for adding this problem and creating all test cases.

<div>

<div id="company_tags" class="btn btn-xs btn-warning">Show Company Tags</div>

<span class="hidebutton">[Google](/company/google/)</span></div>

<div>

<div id="tags" class="btn btn-xs btn-warning">Show Tags</div>

<span class="hidebutton">[Hash Table](/tag/hash-table/) [Heap](/tag/heap/) [Greedy](/tag/greedy/)</span></div>