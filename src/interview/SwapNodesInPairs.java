package interview;

// https://leetcode.com/problems/swap-nodes-in-pairs/
// Given 1->2->3->4, you should return the list as 2->1->4->3.

public class SwapNodesInPairs {
	class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) return head; 
        ListNode p = null, q = null, temp = null;
        p = head;
        ListNode newhead = p.next;
        while (true) {
            q = p.next;
            temp = q.next;
            q.next = p;
            if (temp == null) {
                p.next = null;
                break;
            }
            if (temp.next == null) {
                p.next = temp;
                break;
            }
            p.next = temp.next;
            p = temp;
        }
        return newhead;
    }
	
	public static void main(String[] args) {
		SwapNodesInPairs SNIP = new SwapNodesInPairs();
		ListNode two = null, three = null, four = null;
		ListNode head = SNIP. new ListNode(1);
		two = SNIP. new ListNode(2);
		//three = SNIP. new ListNode(3);
		//four = SNIP. new ListNode(4);
		head.next = two;
		two.next = null;
		//three.next = null;
		//four.next = null;
		
		ListNode result = SNIP.swapPairs(head);
		
		while (result != null) {
			System.out.print(result.val);
			result = result.next;
		}
	}

}
