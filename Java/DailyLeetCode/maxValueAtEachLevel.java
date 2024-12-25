class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();
        List<Integer> ans= new ArrayList<>();
        if(root==null)
            return ans;

        q.add(root);
        while(!q.isEmpty()){
            int n= q.size();
            int max= Integer.MIN_VALUE;

            while(n-->0){
                TreeNode temp= q.poll();
                max= Math.max(max, temp.val);
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }

            ans.add(max);
        }

        return ans;
    }
}