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
class Index{
    int index;
}
class Solution {
    public int search(int[] a, int s, int e, int val){
        for(int i=s ; i<=e ; ++i){
            if(a[i]==val)
                return i;
        }
        return 0;
    }
    public TreeNode buildTreeUtil(int[] in, int[] po, int inStart, int inEnd, Index pIndex){
        if(inStart > inEnd)
            return null;
        TreeNode t=new TreeNode(po[pIndex.index]);
        (pIndex.index)--;
        if(inStart == inEnd) //node has no children. End of array
            return t;
        
        //finding the index of t in inorder array.
        int inIndex = search(in, inStart, inEnd, t.val);
        
        //all to the left of t are the left subtree of t and similarly right subtree.
        t.right = buildTreeUtil(in, po, inIndex+1, inEnd, pIndex);
        t.left = buildTreeUtil(in, po, inStart, inIndex-1, pIndex);
        
        return t;
        
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0 || postorder.length==0)
            return null;
        int n=inorder.length;
        if(n==1)
            return new TreeNode(inorder[0]);
        Index pIndex = new Index(); 
        pIndex.index = n - 1; 
        return buildTreeUtil(inorder, postorder, 0, n-1, pIndex);
    }
}
