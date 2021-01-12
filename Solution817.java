import java.util.HashSet;
import java.util.Set;

class Solution817 {
	public class ListNode {
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
	}

	public int numComponents(ListNode head, int[] G) {
		Set<Integer> set = new HashSet<>();
		for(int i:G) {
			set.add(i);
		}
		
		ListNode node = head;
		int count = 0;
		int result=0;
		int now = 0;
		while( node != null) {
			now = node.val;
			
			if(set.contains(now)) {
				count++;
			}else {
				if(count!=0) {
					result++;
					count=0;
				}
			}
			
			node = node.next;
			
		}
		return result;
	}
}