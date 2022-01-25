/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * 
 * Given an integer array nums where the elements are sorted in ascending order, 
 * convert it to a height-balanced binary search tree.

    A height-balanced binary tree is a binary tree in which the depth of the two 
    subtrees of every node never differs by more than one.
 */

package solutions;

public class ConvertSortedArrayToBST {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		return helper(0, nums.length - 1, nums);
	}

	private TreeNode helper(int left, int right,
		int[] nums) {
		if (left > right) {
			return null;
		}
		int mid = left + (right - left) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(left, mid - 1, nums);
		root.right = helper(mid + 1, right, nums);
		return root;
	}
}
