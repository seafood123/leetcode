class Solution1022 {
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    static int sum;
    
    public int sumRootToLeaf(TreeNode root) {
        sum = 0;
        dfs(root, 0);
        return sum;
    }

    public void dfs(TreeNode root, int num) {
        num = num * 2 + root.val;
        if(root.left == null && root.right == null) {
            sum += num;
            return;
        }
    
        if (root.left != null) {
            dfs(root.left, num);
        }
        if(root.right != null) {
            dfs(root.right, num);
        }
    }
    
    public static void main(String[] args) {
        Solution1022 s = new Solution1022();
        s.sumRootToLeaf(
                new TreeNode(1,
                        new TreeNode(1), null));
    }
}