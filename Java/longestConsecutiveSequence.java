class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length==0)
            return 0;
            
        int size= 0;
        HashSet<Integer> check= new HashSet<>();

        for(int i:nums)
        check.add(i);

        int n= nums.length;
        int i=0;

        while(i<n){
            if(!check.contains(nums[i]-1)){
                int count= 0;
                int curr= nums[i]+1;
                if(check.contains(curr)){
                    while(check.contains(curr)){
                        count+=1;
                        curr+=1;
                    }
                }
                size= Math.max(count, size);
            }
            
            i+=1;
        }

        return size+1;
    }
}