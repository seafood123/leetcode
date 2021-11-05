import java.util.ArrayList;
import java.util.List;

class Solution_day12 {
	  public static class ListNode {
		  int val;
		  ListNode next;
		  ListNode() {}
		  ListNode(int val) { this.val = val; }
		  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
		ListNode n1 = new ListNode(9, new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,null)))))));
		ListNode n2 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,null))));
//		ListNode n1 = new ListNode(2,new ListNode(4, new ListNode(3,null)));
//		ListNode n2 = new ListNode(5, new ListNode(6, new ListNode(4,null)));
//		ListNode n1 = new ListNode(0,null);
//		ListNode n2 = new ListNode(0,null);
		System.out.println(addTwoNumbers(n1,n2));
	}

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	
    	ListNode n1 = l1;
    	ListNode n2 = l2;
    	
    	ListNode zero = new ListNode(0, null);
    	
    	ListNode node = zero;
    	int carry = 0;
    	int sum = 0;
    	while(n1 !=null || n2 != null) {
    		sum = 0;
    		if(n1!=null) {
    			sum += n1.val;
    		}
    		if(n2!=null) {
    			sum += n2.val;
    		}
    		sum += carry;
    		
    		carry = sum / 10;
    		sum -= carry * 10;
    		
    		node.next = new ListNode(sum);
    		node = node.next;
    		
    		if(n1 != null) { n1 = n1.next; }
    		if(n2 != null) { n2 = n2.next; }
    		
    	}
    	
    	if(carry > 0) {
    		node.next = new ListNode(carry);
    	}
        
    	return zero.next;
    }
}