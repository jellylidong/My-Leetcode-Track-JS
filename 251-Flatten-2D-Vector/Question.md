# 251. Flatten 2D Vector

[Original Page](https://leetcode.com/problems/flatten-2d-vector/)

Implement an iterator to flatten a 2d vector.

For example,  
Given 2d vector =

<pre>[
  [1,2],
  [3],
  [4,5,6]
]
</pre>

By calling _next_ repeatedly until _hasNext_ returns false, the order of elements returned by _next_ should be: `[1,2,3,4,5,6]`.

**Hint:**

[Show Hint](#)

1.  How many variables do you need to keep track?[Show More Hint](#)
2.  Two variables is all you need. Try with `x` and `y`.[Show More Hint](#)
3.  Beware of empty rows. It could be the first few rows.[Show More Hint](#)
4.  To write correct code, think about the [invariant](https://en.wikipedia.org/wiki/Invariant_(computer_science)) to maintain. What is it?[Show More Hint](#)
5.  The invariant is `x` and `y` must always point to a valid point in the 2d vector. Should you maintain your invariant _ahead of time_ or _right when you need it_?[Show More Hint](#)
6.  Not sure? Think about how you would implement `hasNext()`. Which is more complex?[Show More Hint](#)
7.  Common logic in two different places should be refactored into a common method.

**Follow up:**  
As an added challenge, try to code it using only [iterators in C++](http://www.cplusplus.com/reference/iterator/iterator/) or [iterators in Java](http://docs.oracle.com/javase/7/docs/api/java/util/Iterator.html).

<div>

<div id="company_tags" class="btn btn-xs btn-warning">Show Company Tags</div>

<span class="hidebutton">[Google](/company/google/) [Airbnb](/company/airbnb/) [Twitter](/company/twitter/) [Zenefits](/company/zenefits/)</span></div>

<div>

<div id="tags" class="btn btn-xs btn-warning">Show Tags</div>

<span class="hidebutton">[Design](/tag/design/)</span></div>

<div>

<div id="similar" class="btn btn-xs btn-warning">Show Similar Problems</div>

<span class="hidebutton">[(M) Binary Search Tree Iterator](/problems/binary-search-tree-iterator/) [(M) Zigzag Iterator](/problems/zigzag-iterator/) [(M) Peeking Iterator](/problems/peeking-iterator/) [(M) Flatten Nested List Iterator](/problems/flatten-nested-list-iterator/)</span></div>