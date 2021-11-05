class Solution445 {
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
		ListNode l1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
		ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
		System.out.println(addTwoNumbers(l1, l2));
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode n1 = l1;
		ListNode n2 = l2;
		
		ListNode parent = new ListNode();
		
		int l1Index = getNodeIndex(n1);
		int l2Index = getNodeIndex(n2);
		
		int carry = dfs(l1, l1Index, l2, l2Index, parent);
		ListNode root;
		if(carry > 0) {
			root = new ListNode(carry, parent);
		}else {
			root = parent;
		}
		
		return root;
		
		
	
		
	}
	
	public static int dfs(ListNode l1, int l1Index,  ListNode l2, int l2Index, ListNode parent) {
		
		if(l1 == null && l2 == null) return 0;
		
		int sum = 0;
		if(l1.next != null || l2.next != null) {
			parent.next = new ListNode();
		}
		if(l1Index > l2Index) {
			sum += l1.val + dfs(l1.next , --l1Index, l2, l2Index, parent.next);
		}else if(l1Index < l2Index) {
			sum += l2.val + dfs(l1, l1Index, l2.next, --l2Index , parent.next);
		}else {
			sum += l1.val + l2.val + dfs(l1.next , --l1Index, l2.next, --l2Index, parent.next);
		}
		
		int carry = sum / 10;
		sum -= carry * 10;
		
		parent.val = sum;
		
		return carry;
		
	}
	
	public static int getNodeIndex(ListNode node) {
		int index = 0;
		while(node!=null) {
			index ++;
			node = node.next;
		}
		return index;
	}
}