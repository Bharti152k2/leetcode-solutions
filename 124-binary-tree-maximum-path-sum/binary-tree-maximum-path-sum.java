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
    int res=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root);
        return res;
    }
    public int dfs(TreeNode root){
        int leftSum=0;
        int rightSum=0;
        if(root.left!=null){
            leftSum=Math.max(0,dfs(root.left));
        }
        if(root.right!=null){
            rightSum=Math.max(0,dfs(root.right));
        }
        res= Math.max(res,(leftSum +rightSum+root.val));
        return Math.max(leftSum,rightSum)+root.val;
    }
}