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
class Ans {
    int a = 0;
}

class Solution {

    public int goodNodes(TreeNode root) {
        Ans ans = new Ans();
        helper(root, ans, root.val);
        return ans.a;
    }

    public void helper(TreeNode root, Ans ans, int max) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (root.val >= max) ans.a++;
            return;
        }
        if (root.val >= max) ans.a++;
        max = max < root.val ? root.val : max;
        helper(root.left, ans, max);
        helper(root.right, ans, max);
    }
}
