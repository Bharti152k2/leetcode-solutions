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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Map<Integer,Integer> hmap=new LinkedHashMap<>();
        dfs(root,0,hmap);
        for(Map.Entry<Integer,Integer> entry: hmap.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
    public void dfs(TreeNode root, int level,Map<Integer,Integer> hmap){
        hmap.put(level,root.val);
        if(root.left!=null){
            dfs(root.left,level+1, hmap);
        }
        if(root.right!=null){
            dfs(root.right,level+1, hmap);
        }
    }
}