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
    public int widthOfBinaryTree(TreeNode root) {
        // METHOD 1: BFS: TC - O(n^2)
        
        if(root==null)
            return 0;
        int max=1;
        Deque<TreeNode> q=new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){ 
            //removing the dummy values inserted from boundaries of the queue until they encounter the first non-dummy value
            while(q.isEmpty()==false && q.peekLast().val==Integer.MIN_VALUE)
                q.pollLast();
            while(q.isEmpty()==false && q.peekFirst().val==Integer.MIN_VALUE)
                q.pollFirst();
            
            int qSize=q.size(); //width of the level
            max=Math.max(max, qSize);
            
            for(int i=0 ; i<qSize ; ++i){
                TreeNode curr=q.poll();
                if(curr.left!=null)
                    q.offer(curr.left);
                else
                    q.offer(new TreeNode(Integer.MIN_VALUE));   //inserting dummy
                if(curr.right!=null)
                    q.offer(curr.right);
                else
                    q.offer(new TreeNode(Integer.MIN_VALUE));   //inserting dummy
            }
        }
        return max;
    }
}
