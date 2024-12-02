class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
 
class Solution {
    static TreeNode move(TreeNode root){

        if(root== null)
            return root;

        move(root.left);
        move(root.right);

        TreeNode temp= root.left;
        root.left= root.right;
        root.right= temp;

        return root;
    }
    public TreeNode invertTree(TreeNode root) {
        return move(root);
    }
}