import java.util.Arrays;

class Solution382 {
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
    }
    public ListNode listNode;
    public int[] listNodeArr;
    public int len;
    public Solution382(ListNode head) {
        this.listNode = head;
        listNodeArr = new int[10001];
        Arrays.fill(listNodeArr, Integer.MIN_VALUE);
        len = getLength();
    }
    public int getLength() {
        int count = 0;
        ListNode copy = this.listNode;
        while(copy != null) {
            copy = copy.next;
            count++;
        }
        return count;
    }
    public int getRandom() {
        int random = (int) (Math.random() * len);
        if(listNodeArr[random] != Integer.MIN_VALUE) return listNodeArr[random];

        int count = 0;
        ListNode copy = this.listNode;
        while(count++ < random) {
            copy = copy.next;
        }

        listNodeArr[random] = copy.val;
        return copy.val;
    }

    public static void main(String[] args) {
        Solution382 s = new Solution382(new ListNode(3));
        System.out.println(s.getRandom());
    }
}
/*
/
  Your Solution object will be instantiated and called as such:
  Solution obj = new Solution(head);
  int param_1 = obj.getRandom();
 /*/
