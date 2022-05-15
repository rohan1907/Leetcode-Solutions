/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int sum = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            sum = 0; // Reset for calculating the sum of elements of the next level
            while (size-- > 0) {
                TreeNode top = q.poll();
                sum += top.val;
                if (top.left != null) q.offer(top.left);
                if (top.right != null) q.offer(top.right);
            }
        }
        return sum;
    }
}