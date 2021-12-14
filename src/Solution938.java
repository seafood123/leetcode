import java.util.*;

class Solution938 {
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
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        int now = root.val;
        if (now >= low && now <= high) {
            return now + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }else if(now < low) {
            return rangeSumBST(root.right, low, high);
        }else if(now > high) {
            return rangeSumBST(root.left, low, high);
        }else {
            return 0;
        }
    }
}