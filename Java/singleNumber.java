// O(N^2)
class Solution {
    public int singleNumber(int[] nums) {
        for(int i=0; i<nums.length; i++){
            int k= nums[i];
            boolean bool= false;

            for(int j=0; j<nums.length; j++){
                if(i!=j){
                    int x= k^nums[j];
                    if(x==0){
                        bool= true;
                        break;
                    }
                }
            }

            if(!bool){
                return k;
            }
        }

        return -1;
    }
}

// O(N)

class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<=nums.length-1;i++){
            ans^=nums[i];
        }
        return ans;
    }
}