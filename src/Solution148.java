
class Solution148 {
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

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        // 1. 분할!
        ListNode oneStepSlow = new ListNode(0, head);
        ListNode start = oneStepSlow;
        ListNode left = head;
        ListNode right = head;

        while(right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
            oneStepSlow = oneStepSlow.next;
        }
        oneStepSlow.next = null;
        ListNode leftGroup = sortList(start.next);
        ListNode rightGroup = sortList(left);

        ListNode result = mergeSort(leftGroup, rightGroup);
        return result;
    }

    private ListNode mergeSort(ListNode leftGroup, ListNode rightGroup) {
        ListNode result = new ListNode();
        ListNode copy = result;
        while(leftGroup != null && rightGroup != null) {
            if(leftGroup.val < rightGroup.val) {
                result.next = new ListNode(leftGroup.val);
                leftGroup = leftGroup.next;
            } else {
                result.next = new ListNode(rightGroup.val);
                rightGroup = rightGroup.next;
            }
            result = result.next;
        }


        if(leftGroup != null) result.next = leftGroup;
        if(rightGroup != null) result.next = rightGroup;
        return copy.next;
    }

    public static void main(String[] args) {
        Solution148 solution148 = new Solution148();
        ListNode result = solution148.sortList(new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0))))));
        System.out.println(result.toString());
    }
}