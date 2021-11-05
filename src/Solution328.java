
class Solution328 {
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
            final StringBuffer sb = new StringBuffer("ListNode{");
            sb.append("val=").append(val);
            sb.append(", next=").append(next);
            sb.append('}');
            return sb.toString();
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        ListNode copyOdd = odd;


        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return copyOdd;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,2,3,4,5};
        ListNode problem = new ListNode();
        ListNode copy = problem;
        for(int i : array) {
            problem.next = new ListNode(i);
            problem = problem.next;
        }
//        System.out.println(copy.next.toString());

        ListNode result = oddEvenList(copy.next);
        System.out.println(result.toString());
    }
}