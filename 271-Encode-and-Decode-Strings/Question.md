# 271. Encode and Decode Strings

[Original Page](https://leetcode.com/problems/encode-and-decode-strings/)

Design an algorithm to encode **a list of strings** to **a string**. The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

<pre>string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}</pre>

Machine 2 (receiver) has the function:

<pre>vector<string> decode(string s) {
  //... your code
  return strs;
}</pre>

So Machine 1 does:

<pre>string encoded_string = encode(strs);</pre>

and Machine 2 does:

<pre>vector<string> strs2 = decode(encoded_string);</pre>

`strs2` in Machine 2 should be the same as `strs` in Machine 1.

Implement the `encode` and `decode` methods.

**Note:**  

*   The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
*   Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
*   Do not rely on any library method such as `eval` or serialize methods. You should implement your own encode/decode algorithm.

<div>

<div id="company_tags" class="btn btn-xs btn-warning">Show Company Tags</div>

<span class="hidebutton">[Google](/company/google/)</span></div>

<div>

<div id="tags" class="btn btn-xs btn-warning">Show Tags</div>

<span class="hidebutton">[String](/tag/string/)</span></div>

<div>

<div id="similar" class="btn btn-xs btn-warning">Show Similar Problems</div>

<span class="hidebutton">[(E) Count and Say](/problems/count-and-say/) [(H) Serialize and Deserialize Binary Tree](/problems/serialize-and-deserialize-binary-tree/)</span></div>