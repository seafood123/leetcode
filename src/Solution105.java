import java.util.HashMap;
import java.util.Map;

class Solution105 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("TreeNode{");
            sb.append("val=").append(val);
            sb.append(", left=").append(left);
            sb.append(", right=").append(right);
            sb.append('}');
            return sb.toString();
        }
    }
    public static int preOrderIndex = 0;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for(int i=0; i<inorder.length;i++) {
            inOrderMap.put(inorder[i], i);
        }
        return makeChildTree(0, preorder.length, preorder, inOrderMap);
    }

    public static TreeNode makeChildTree(int start, int end, int[] preorder, Map<Integer, Integer> inOrderMap) {
        TreeNode head = null;
        if(start > end || start >= preorder.length) return null;
        int value = preorder[preOrderIndex++];
        head = new TreeNode(value);

        // start 부터 leftIndex 까지가 현재 head 의 left child가 된다.

        head.left = makeChildTree(start, inOrderMap.get(value)-1, preorder, inOrderMap);
        head.right = makeChildTree(inOrderMap.get(value)+1, end, preorder, inOrderMap);
        return head;
    }

    public static void main(String[] args) {
        // preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        int[] preorder = new int[]{-1};
        int[] inorder = new int[] {-1};
        TreeNode result = buildTree(preorder, inorder);
        System.out.println(result.toString());
    }
}