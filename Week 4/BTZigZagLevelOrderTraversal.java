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
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
            return res;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        boolean left=true;
        while(!q.isEmpty()){
            List<Integer> level=new ArrayList<>();
            int s=q.size();
            for(int i=0 ; i<s ; ++i){
                TreeNode temp=q.poll();
                
                if(left==true)
                    level.add(temp.val);
                else
                    level.add(0, temp.val);
                
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);
            }
            left=!left;
            res.add(level);
        }
        return res;
    }
}
