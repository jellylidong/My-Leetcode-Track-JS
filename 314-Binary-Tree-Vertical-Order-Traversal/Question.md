# 314. Binary Tree Vertical Order Traversal

[Original Page](https://leetcode.com/problems/binary-tree-vertical-order-traversal/)

Given a binary tree, return the _vertical order_ traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from **left to right**.

**Examples:**  

1.  Given binary tree `[3,9,20,null,null,15,7]`,  

    <pre>   3
      /\
     /  \
     9  20
        /\
       /  \
      15   7
    </pre>

    return its vertical order traversal as:  

    <pre>[
      [9],
      [3,15],
      [20],
      [7]
    ]
    </pre>

2.  Given binary tree `[3,9,8,4,0,1,7]`,  

    <pre>     3
        /\
       /  \
       9   8
      /\  /\
     /  \/  \
     4  01   7
    </pre>

    return its vertical order traversal as:  

    <pre>[
      [4],
      [9],
      [3,0,1],
      [8],
      [7]
    ]
    </pre>

3.  Given binary tree `[3,9,8,4,0,1,7,null,null,null,2,5]` (0's right child is 2 and 1's left child is 5),  

    <pre>     3
        /\
       /  \
       9   8
      /\  /\
     /  \/  \
     4  01   7
        /\
       /  \
       5   2
    </pre>

    return its vertical order traversal as:  

    <pre>[
      [4],
      [9,5],
      [3,0,1],
      [8,2],
      [7]
    ]
    </pre>

<div>

<div id="company_tags" class="btn btn-xs btn-warning">Show Company Tags</div>

<span class="hidebutton">[Google](/company/google/) [Snapchat](/company/snapchat/) [Facebook](/company/facebook/)</span></div>

<div>

<div id="tags" class="btn btn-xs btn-warning">Show Tags</div>

<span class="hidebutton">[Hash Table](/tag/hash-table/)</span></div>

<div>

<div id="similar" class="btn btn-xs btn-warning">Show Similar Problems</div>

<span class="hidebutton">[(E) Binary Tree Level Order Traversal](/problems/binary-tree-level-order-traversal/)</span></div>