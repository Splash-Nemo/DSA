class Solution {
    public int maxArea(int[] height) {
        int ans= 0;
        int n= height.length;

        int si=0, ei= n-1;

        while(si<ei){
            int k= Math.min(height[si], height[ei])*(ei-si);
            ans= Math.max(ans,k);

            if(height[si]<height[ei])
                si+=1;
            else if(height[si]>height[ei])
                ei-=1;
            else{
                si+=1;
                ei-=1;
            }
        }

        return ans; 
    }
}