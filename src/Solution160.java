
public class Solution160 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

		@Override
		public String toString() {
			final StringBuffer sb = new StringBuffer("ListNode{");
			sb.append("val=").append(val);
			sb.append(", next=").append(next);
			sb.append('}');
			return sb.toString();
		}
	}

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    	// 우선 두 List의 길이를 맞춘다.
		int lenA = getLength(headA);
		int lenB = getLength(headB);

		ListNode moveA = moveKthNode(headA, lenA - lenB);
		ListNode moveB = moveKthNode(headB, lenB - lenA);

		while(moveA != moveB ) {
			moveA = moveA.next;
			moveB = moveB.next;
		}

		return moveA;
    }

    public static ListNode moveKthNode(ListNode node, int len) {
    	ListNode copy = node;
    	while(len-- > 0) {
    		copy = copy.next;
		}
    	return copy;
	}

    public static int getLength(ListNode node) {
    	int len = 0;
    	ListNode copy = node;
    	while(copy != null) {
    		len++;
    		copy = copy.next;
		}
    	return len;
	}

	public static void main(String[] args) {
		ListNode headA = new ListNode(0);
		ListNode headB = new ListNode(0);

		int[] a = new int[]{4,1,8,4,5};
		int[] b = new int[]{5,6,1,8,4,5};

		ListNode copyA = headA;
		ListNode copyB = headB;

		for(int value : a) {
			headA.next = new ListNode(value);
			headA = headA.next;
		}
		for(int value : b) {
			headB.next = new ListNode(value);
			headB = headB.next;
		}

		ListNode result = getIntersectionNode(copyA.next, copyB.next);

		System.out.println(result.toString());
//
//		System.out.println(copyA);
//		System.out.println(copyB);
	}
}