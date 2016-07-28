# 312. Burst Balloons

[Original Page](https://leetcode.com/problems/burst-balloons/)

Given `n` balloons, indexed from `0` to `n-1`. Each balloon is painted with a number on it represented by array `nums`. You are asked to burst all the balloons. If the you burst balloon `i` you will get `nums[left] * nums[i] * nums[right]` coins. Here `left` and `right` are adjacent indices of `i`. After the burst, the `left` and `right` then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

**Note:**  
(1) You may imagine `nums[-1] = nums[n] = 1`. They are not real therefore you can not burst them.  
(2) 0 ≤ `n` ≤ 500, 0 ≤ `nums[i]` ≤ 100

**Example:**

Given `[3, 1, 5, 8]`

Return `167`

<pre>    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
</pre>

**Credits:**  
Special thanks to [@dietpepsi](https://leetcode.com/discuss/user/dietpepsi) for adding this problem and creating all test cases.

<div>

<div id="company_tags" class="btn btn-xs btn-warning">Show Company Tags</div>

<span class="hidebutton">[Google](/company/google/)</span></div>

<div>

<div id="tags" class="btn btn-xs btn-warning">Show Tags</div>

<span class="hidebutton">[Divide and Conquer](/tag/divide-and-conquer/) [Dynamic Programming](/tag/dynamic-programming/)</span></div>