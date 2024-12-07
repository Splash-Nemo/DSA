class Solution {

    int ans=0;

    public int height(TreeNode root){
        if(root==null)
            return 0;

        int left= height(root.left);
        int right= height(root.right);

        ans= Math.max(ans, left+right);

        return Math.max(left,right)+1;
    }

    public int diameterOfBinaryTree(TreeNode root) {

        height(root);        
        return ans;
    }
}