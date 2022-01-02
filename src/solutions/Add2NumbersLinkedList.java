package solutions;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 +
 * 465 = 807.
 */

class ListNode {
	int val;
	ListNode next;
	
	ListNode(int val) {
		this.val = val;
	}
}

public class Add2NumbersLinkedList {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode current = dummyHead;
		int carry = 0, sum = 0;
		while (l1 != null || l2 != null) {
			int x = (l1 != null) ? l1.val : 0;
			int y = (l2 != null) ? l2.val : 0;

			sum = carry + x + y;
			carry = sum / 10;
			current.next = new ListNode(sum % 10); // create new node with digit
			current = current.next;

			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		if (carry > 0) {
			current.next = new ListNode(carry);
		}
		return dummyHead.next; // return the node after the dummy node
	}

	public static void main(String[] args) {

	}

}
