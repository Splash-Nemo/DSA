import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] ans= new int[2];
        
        HashMap<Integer, Integer> abc= new HashMap<>();
        for(int i=0; i<nums.length; i++){
            abc.put(nums[i], i);
        }

        for(int i=0; i<nums.length; i++){
            if(abc.containsKey(target-nums[i])){
                if(abc.get(target-nums[i])!=i){
                    ans[0]= i;
                    ans[1]= abc.get(target-nums[i]);
                    break;
                }
            }
        }

        return ans;
    }
}