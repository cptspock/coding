package interview;

public class InorderSuccessor {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
	
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null) return null;
		TreeNode cur = root, pre = null;
		while (cur != null) { // p = 9
			if (cur.val > p.val) { 
				pre = cur; // pre = 11
				cur = cur.left; // cur = null 
			} else {
				cur = cur.right; // cur = 
			}
		}
		return pre;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
