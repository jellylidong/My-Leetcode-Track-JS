# 333. Largest BST Subtree

[Original Page](https://leetcode.com/problems/largest-bst-subtree/)

Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

**Note:**  
A subtree must include all of its descendants.  
Here's an example:  

<pre>    10
    / \
   <font color="red">5</font>  15
  <font color="red">/ \</font>   \ 
 <font color="red">1   8</font>   7
</pre>

The Largest BST Subtree in this case is the highlighted one.  
The return value is the subtree's size, which is 3\.

**Hint:**

[Show Hint](#)

1.  You can recursively use algorithm similar to [98\. Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/) at each node of the tree, which will result in O(nlogn) time complexity.

**Follow up:**  
Can you figure out ways to solve it with O(n) time complexity?

<div>

<div id="company_tags" class="btn btn-xs btn-warning">Show Company Tags</div>

<span class="hidebutton">[Microsoft](/company/microsoft/)</span></div>

<div>

<div id="tags" class="btn btn-xs btn-warning">Show Tags</div>

<span class="hidebutton">[Tree](/tag/tree/)</span></div>