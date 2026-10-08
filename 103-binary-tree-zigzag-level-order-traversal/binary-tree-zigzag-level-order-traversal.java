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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> res= new ArrayList<>();
        if(root==null){
            return res;
        }
        queue.add(root);
        int level=0;
        while(queue.size()>0){
            int t= queue.size();
            List<Integer> arr= new ArrayList<>();
            while(t>0){
                TreeNode curr=queue.poll();
                arr.add(curr.val);
                t--;
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }
            if(level%2!=0){
                Collections.reverse(arr);
            }
            res.add(arr);
            level++;
        }

        return res;

    }
}