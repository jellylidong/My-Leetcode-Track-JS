# 272. Closest Binary Search Tree Value II

[Original Page](https://leetcode.com/problems/closest-binary-search-tree-value-ii/)

Given a non-empty binary search tree and a target value, find _k_ values in the BST that are closest to the target.

**Note:**  

*   Given target value is a floating point.
*   You may assume _k_ is always valid, that is: _k_ ≤ total nodes.
*   You are guaranteed to have only one unique set of _k_ values in the BST that are closest to the target.

**Follow up:**  
Assume that the BST is balanced, could you solve it in less than _O_(_n_) runtime (where _n_ = total nodes)?

**Hint:**

[Show Hint](#)

1.  Consider implement these two helper functions:
    1.  `getPredecessor(N)`, which returns the next smaller node to N.
    2.  `getSuccessor(N)`, which returns the next larger node to N.[Show More Hint](#)
2.  Try to assume that each node has a parent pointer, it makes the problem much easier.[Show More Hint](#)
3.  Without parent pointer we just need to keep track of the path from the root to the current node using a stack.[Show More Hint](#)
4.  You would need two stacks to track the path in finding predecessor and successor node separately.

<div>

<div id="company_tags" class="btn btn-xs btn-warning">Show Company Tags</div>

<span class="hidebutton">[Google](/company/google/)</span></div>

<div>

<div id="tags" class="btn btn-xs btn-warning">Show Tags</div>

<span class="hidebutton">[Tree](/tag/tree/) [Stack](/tag/stack/)</span></div>

<div>

<div id="similar" class="btn btn-xs btn-warning">Show Similar Problems</div>

<span class="hidebutton">[(M) Binary Tree Inorder Traversal](/problems/binary-tree-inorder-traversal/) [(E) Closest Binary Search Tree Value](/problems/closest-binary-search-tree-value/)</span></div>