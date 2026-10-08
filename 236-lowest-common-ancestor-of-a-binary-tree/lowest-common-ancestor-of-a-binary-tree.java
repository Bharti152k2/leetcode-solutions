/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode res=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return res;
    }
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        boolean current=false;
        boolean left=false;
        boolean right=false;
        if(root==p||root==q){
            current=true;
        }
        if(root.left!=null){
            left=dfs(root.left,p,q);
        }
        if(root.right!=null){
            right=dfs(root.right,p,q);
        }
        if((left && right) || (left && current) || (right && current)){
            res=root;
        }
        return current || left ||  right;
    }
}