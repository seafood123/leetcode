
class Solution563 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int result = 0;

    public int findTilt(TreeNode root) {
        result = 0;
        if (root == null || (root.left == null && root.right == null)) return 0;
        getSumAndTilt(root);
        return result;
    }

    public int getSumAndTilt(TreeNode root) {
        if (root == null) return 0;

        int left = getSumAndTilt(root.left);
        int right = getSumAndTilt(root.right);

        result += Math.abs(left - right);

        return root.val + left + right;

    }
}