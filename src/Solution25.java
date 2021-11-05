public class Solution25 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val =val;
        }
        ListNode(int val,ListNode next) {
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
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(k==1) return head;
        ListNode copy = head;
        int cnt = 1;
        ListNode header = head;
        ListNode tail = head;
        ListNode ne = null;
        while(header != null ){
            cnt = 1;
            while(cnt < k) {
                cnt++;
                header = header.next;
                if(header == null) return head;
            }
//            System.out.println("header::" + header);
            while(cnt != 1) {
                ne = tail.next;
                if(tail.next == null) {
                    tail.next = null;
                } else {
                    tail.next = tail.next.next;
                    ne.next = tail;
                    tail = ne;
                    tail = tail.next;
                    System.out.println("tail::"+ tail);
                    System.out.println("ne::"+ ne);
//                    tail = ne;
                }
                cnt--;
            }

        }

        return copy;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2));
        ListNode result = reverseKGroup(node, 2);
        System.out.println(result);
    }

}
