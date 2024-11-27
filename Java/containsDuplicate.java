import java.util.*;
class containsDuplicate {
    public boolean Duplicate(int[] nums) {
        HashMap<Integer, Integer> abc= new HashMap<>();
        for(int i: nums){
            if(abc.containsKey(i))
                return true;

            abc.put(i, abc.getOrDefault(i, 1));
        }

        return false;
    }
}