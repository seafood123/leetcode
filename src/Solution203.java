

class Solution203 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode result = new ListNode();
        result.next = head;
        ListNode copy = result;

        while(result.next != null) {
            if(result.next.val == val) {
                result.next = result.next.next;
            }
            result = result.next;
        }

        return copy.next;
    }

    public static void main(String[] args) {

    }
}