import java.util.PriorityQueue;

class Solution23 {
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

    // #2
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val-b.val);
        for(ListNode list : lists) {
            if(list != null) {
                pq.offer(list);
            }
        }
        ListNode result = new ListNode();
        ListNode copy = result;
        ListNode nowList = null;
        while(!pq.isEmpty()) {
            nowList = pq.poll();
            result.next = nowList;
            result = result.next;
            if(nowList.next != null) {
                pq.offer(nowList.next);
            }
        }
        return copy.next;
    }

    // # 1
    /**
     * public ListNode mergeKLists(ListNode[] lists) {
     *         if (lists == null) return null;
     *         if (lists.length == 0) return new ListNode();
     *         if (lists.length == 1) return lists[0];
     *         ListNode result = lists[0];
     *         for (int i = 1; i < lists.length; i++) {
     *             result = merge(result, lists[i]);
     *         }
     *         return result;
     *     }
     *
     *     public ListNode merge(ListNode n1, ListNode n2) {
     *         ListNode result = new ListNode();
     *         ListNode copy = result;
     *         while (n1 != null && n2 != null) {
     *             if (n1.val <= n2.val) {
     *                 result.next = new ListNode(n1.val);
     *                 n1 = n1.next;
     *             } else {
     *                 result.next = new ListNode(n2.val);
     *                 n2 = n2.next;
     *             }
     *             result = result.next;
     *         }
     *         if (n1 != null) {
     *             result.next = n1;
     *         } else if (n2 != null) {
     *             result.next = n2;
     *         }
     *         return copy.next;
     *      }
     **/

    public static void main(String[] args) {
        Solution23 solution23 = new Solution23();
        //[[1,4,5],[1,3,4],[2,6]]
        ListNode[] list = new ListNode[]{new ListNode(1, new ListNode(4, new ListNode(5))),
                                         new ListNode(1, new ListNode(3, new ListNode(4))),
                                         new ListNode(2, new ListNode(6))};
        ListNode result = solution23.mergeKLists(list);
        System.out.println(result.toString());
    }
}