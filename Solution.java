
class Solution {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("ListNode [val=");
			builder.append(val);
			builder.append(", next=");
			builder.append(next);
			builder.append("]");
			return builder.toString();
		}
		
		
	}
	
	public static void main(String[] args) {
		ListNode node2 = new ListNode(2, null);
		ListNode node1 = new ListNode(1,node2);
		ListNode node0 = new ListNode(0,node1);
		
		System.out.println(rotateRight(node0, 4));
	}

	public static ListNode rotateRight(ListNode head, int k) {
		ListNode tail = head;
		int index =1;
		while(tail.next!=null) {
			index++;
			tail = tail.next;
		}
		
		tail.next = head;
		
		System.out.println(tail.val);
		
		int dest = index - (k % index);
		
		index = 0;
		ListNode n = head;
		
		System.out.println(dest);
		while(index != dest-1) {
			//System.out.println(index + " : " + n.val);
			n = n.next;
			index++;
		}
		//System.out.println(n.val);
		ListNode temp = n.next;
		n.next = null;
		n = temp;
		
		return n;
		
	}
}