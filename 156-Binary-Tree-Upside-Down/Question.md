# 156. Binary Tree Upside Down

[Original Page](https://leetcode.com/problems/binary-tree-upside-down/)

Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

For example:  
Given a binary tree `{1,2,3,4,5}`,  

<pre>    1
   / \
  2   3
 / \
4   5
</pre>

return the root of the binary tree `[4,5,2,#,#,3,1]`.  

<pre>   4
  / \
 5   2
    / \
   3   1  
</pre>

confused what `"{1,#,2,3}"` means? [> read more on how binary tree is serialized on OJ.](#)

<div class="spoilers" style="display: none;">  
**OJ's Binary Tree Serialization:**

The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:  

<pre>   1
  / \
 2   3
    /
   4
    \
     5
</pre>

The above binary tree is serialized as `"{1,2,3,#,#,4,#,#,5}"`.</div>

<div>

<div id="company_tags" class="btn btn-xs btn-warning">Show Company Tags</div>

<span class="hidebutton">[LinkedIn](/company/linkedin/)</span></div>

<div>

<div id="tags" class="btn btn-xs btn-warning">Show Tags</div>

<span class="hidebutton">[Tree](/tag/tree/)</span></div>

<div>

<div id="similar" class="btn btn-xs btn-warning">Show Similar Problems</div>

<span class="hidebutton">[(E) Reverse Linked List](/problems/reverse-linked-list/)</span></div>