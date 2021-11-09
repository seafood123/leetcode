import javax.swing.tree.TreeNode;
import java.util.*;


class Solution103 {
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
            final StringBuffer sb = new StringBuffer("TreeNode{");
            sb.append("val=").append(val);
            sb.append(", left=").append(left);
            sb.append(", right=").append(right);
            sb.append('}');
            return sb.toString();
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return null;
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curr = null;
        List<Integer> childList = null;
        queue.add(root);
        int cnt = 0;
        boolean flag = true;  // true 이면 <<  , false 이면 >>
        while (!queue.isEmpty()) {
            cnt = queue.size();
            childList = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                curr = queue.poll();
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
                if (flag) {
                    childList.add(curr.val);
                } else {
                    childList.add(childList.size() - i, curr.val);
                }
            }
            result.add(childList);
            flag = !flag;
        }
        return result;
    }

    public static void main(String[] args) {
        // 3,9,20,null,null,15,7
        TreeNode node = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<List<Integer>> result = zigzagLevelOrder(node);
        System.out.println(result.toString());
    }
}