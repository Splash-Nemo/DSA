class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        HashSet<List<Integer>> check= new HashSet<>();

        Arrays.sort(nums);

        int t= 0;
        for(int i=0; i<nums.length; i++){
            int tar= t-nums[i];
            int si= i+1;
            int ei= nums.length-1;

            while(si<ei){
                if(nums[si]+nums[ei]>tar){
                    ei-=1;
                }else if(nums[si]+nums[ei]<tar){
                    si+=1;
                }else{
                    if(!check.contains(Arrays.asList(nums[si], nums[ei], nums[i]))){
                        check.add(Arrays.asList(nums[si], nums[ei], nums[i]));
                        ans.add(Arrays.asList(nums[si], nums[ei], nums[i]));
                    }
                    si+=1;
                    ei-=1;
                }
            }  
        }
        
        return ans;
    }
}