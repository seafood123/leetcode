
class Solution337 {
    public static final TreeProfit ZERO = new TreeProfit(0,0);
    public static class TreeProfit{
        int ifRobbed;
        int ifNotRobbed;
        public TreeProfit(int ifRobbed, int ifNotRobbed) {
            this.ifRobbed = ifRobbed;
            this.ifNotRobbed = ifNotRobbed;
        }

        public int bestProfit() {
            return Math.max(ifNotRobbed, ifRobbed);
        }
    }
    public class TreeNode {
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
    public int rob(TreeNode root) {
        TreeProfit result = findProfit(root);
        return result.bestProfit();
    }

    public TreeProfit findProfit(TreeNode root) {
        TreeProfit leftProfit = root.left != null ? findProfit(root.left) : ZERO;
        TreeProfit rightProfit = root.right != null ? findProfit(root.right) : ZERO;

        // 지금 내가 있는 곳에서 도둑질을 하면 left, right 에선 하면 안돼!
        int nowRobbed = root.val + leftProfit.ifNotRobbed + rightProfit.ifNotRobbed;

        // 여기서 안훔치면
        int notNowRobbed = leftProfit.bestProfit() + rightProfit.bestProfit();

        return new TreeProfit(nowRobbed, notNowRobbed);
    }
}