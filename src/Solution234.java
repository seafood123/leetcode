
class Solution234 {
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

    public boolean isPalindrome(ListNode head) {
        // find middle
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) slow = slow.next;

        // 현재 slow가 가리키고 있는 노드가 middle 노드!
        ListNode rightNode = reverse(slow);
        ListNode leftNode = head;

        while (rightNode != null) {
            if (rightNode.val != leftNode.val) return false;
            rightNode = rightNode.next;
            leftNode = leftNode.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode result = new ListNode();
        ListNode copy = result;
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Solution234 solution234 = new Solution234();
        ListNode node = solution234.reverse(new ListNode(1, new ListNode(2, new ListNode(3))));
        System.out.println(node.toString());
    }
}