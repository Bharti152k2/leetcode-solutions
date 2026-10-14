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
    TreeNode first;
    TreeNode prev;
    TreeNode mid;
    TreeNode last;
    public void recoverTree(TreeNode root) {
        first=null;
        last=null;
        mid=null;
        prev=new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(first!=null && last!=null){
            int t=first.val;
            first.val=last.val;
            last.val=t;
        }else if(first!=null && mid!=null){
            int t=first.val;
            first.val=mid.val;
            mid.val=t;
        }
    }
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left!=null){
            inorder(root.left);
        }
        if(prev!=null && (root.val<prev.val)){
            if(first==null){
                first=prev;
                mid=root;
            }else{
                last=root;
            }
        }
        prev=root;
        if(root.right!=null){
            inorder(root.right);
        }
    }
}