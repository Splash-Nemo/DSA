import java.util.*;
class Solution {
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer,Integer> abc= new HashMap<>();
        
        for(int i=0; i<arr.length; i++){
            if(!abc.containsKey(arr[i])){
                abc.put(arr[i], i);
            }
        }

        for(int i=0; i<arr.length; i++){
            int temp= 2*arr[i];
            if(abc.containsKey(temp)){
                if(abc.get(temp) != i)
                    return true;
            }
        }

        return false;
    }
}