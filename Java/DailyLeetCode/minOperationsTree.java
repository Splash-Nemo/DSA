class Solution {

    public int moves(int[] a,int[] b){
        int move=0;
        int j,i;
        for(i=0;i<a.length;i++){
            int ele=b[i];
            if(a[i]==ele){
                continue;
            }
            else{
                for(j=i;j<a.length;j++){
                    if(a[j]==ele){
                        break;
                    }
                }
                a[j]=a[i];
                move++;
            }
        }
        return move;
    }

    public int levelOrder(TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int ans=0;
        while(!q.isEmpty()){
            int n=q.size();
            int[] arr=new int[n];
            int[] arr2=new int[n];
            int index=0;
            for(int i=0;i<n;i++){
                TreeNode ele=q.poll();
                if(ele.left!=null) {
                    q.add(ele.left);
                }
                if(ele.right!=null) q.add(ele.right);

                arr[index]=ele.val;
                arr2[index++]=ele.val;
            }

            Arrays.sort(arr2);
            ans+=moves(arr,arr2);

        }
        return ans;
    }


    public int minimumOperations(TreeNode root) {
        return levelOrder(root);
    }
}