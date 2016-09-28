/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root){
		StringBuilder sb = new StringBuilder();
		buildString(root, sb);
		return sb.toString();
	}
	
	public void buildString(TreeNode root, StringBuilder sb){
		if(root == null){
			sb.append("null,");
		}
		else{
			sb.append(root.val + ",");
			buildString(root.left, sb);
			buildString(root.right, sb);
		}
	}

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data){
		String[] ss = data.split(",");
		int[] index = {0};
		return buildTree(ss, index);
	}
	
	public TreeNode buildTree(String[] ss, int[] index){
		int cur = index[0];
		index[0]++;
		
		if(ss[cur].equals("null"))	return null;
		else{
			TreeNode root = new TreeNode(Integer.parseInt(ss[cur]));
			root.left = buildTree(ss, index);
			root.right = buildTree(ss, index);
			return root;
		}
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));