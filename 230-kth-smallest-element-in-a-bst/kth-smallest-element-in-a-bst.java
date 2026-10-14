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
    int count=0;
    int res=-1;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);
        return res;
    }
    public void inOrder(TreeNode root,int k){
        if(res>-1){
            return;
        }
        if(root.left!=null){
            inOrder(root.left,k);
        }
        count++;
        if(count==k){
            res=root.val;
            return;
        }
        if(root.right!=null){
            inOrder(root.right,k);
        }
    }
}