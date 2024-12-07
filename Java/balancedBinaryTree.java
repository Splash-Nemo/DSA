// O(N^2) solution
class Solution1 {

    public int height(TreeNode root) {
        if (root == null)
            return 0;

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int l = height(root.left); 
        int r = height(root.right); 

        if (Math.abs(l - r) > 1)
            return false;

        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        return left && right;
    }
}

//O(N) solution
class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root)!=-1;   
    }

    public int height(TreeNode root){
        if(root==null)
            return 0;
        
        int l= height(root.left);
        if(l==-1)
            return -1;

        int r= height(root.right);
        if(r==-1)
            return -1;

        if(Math.abs(l-r)>1)
            return -1;
        
        return Math.max(l,r)+1;
    }
}