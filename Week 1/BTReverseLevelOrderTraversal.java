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
class BTReverseLevelOrderTraversal {      
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>(); //result list
        if(root==null)
            return res;   //null condition
        Deque<TreeNode> q = new ArrayDeque<>(); //Can use a normal Queue interface too
        q.offer(root);
    
        while(!q.isEmpty()){
            List<Integer> level=new ArrayList<Integer>();   //every level is stored here
            int qSize=q.size();     //important since we add more values to q in the for loop
            for(int i=0 ; i<qSize ; ++i){
                TreeNode curr=q.poll();
                level.add(curr.val);
                
                if(curr.left!=null)
                    q.offer(curr.left);
                if(curr.right!=null)
                    q.offer(curr.right);
                
            }  
            res.add(0, level);  //add to front of list
        }
        return res;
    }
}
