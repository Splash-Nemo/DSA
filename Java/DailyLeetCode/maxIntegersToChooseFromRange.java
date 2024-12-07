class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        
        HashSet<Integer> bset= new HashSet<>();
        
        for(int i: banned){
            if(i<=n)
                bset.add(i);
        }

        int sum=0; 
        int size= 0;

        for(int i=1; i<=n; i++){
            if(!bset.contains(i)){
                System.out.print(i+" ");
                sum+=i;
                if(sum<=maxSum){
                    size+=1;
                }else{
                    break;
                }
            }
        }

        return size;
    }
}