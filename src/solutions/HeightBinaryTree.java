/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Height is same as max depth of a binary tree
 * https://www.youtube.com/watch?v=_O-mK2g_jhI
 */
package solutions;

public class HeightBinaryTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
	public int maxDepth(TreeNode root) {
		if (root == null) return 0; //base case for leaf node
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return Math.max(left, right) + 1;
		
	}

	public static void main(String[] args) {

	}

}
