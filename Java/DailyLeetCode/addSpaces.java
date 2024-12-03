import java.util.*;
class Solution {
    public String addSpaces(String s, int[] spaces) {
        HashSet<Integer> abc= new HashSet<>();

        for(int i: spaces){
            abc.add(i);
        }

        String[] temp= s.split("");
        StringBuilder ans= new StringBuilder();

        for(int i=0; i<temp.length; i++){
            if(abc.contains(i)){
                ans.append(' ');
            }
            ans.append(temp[i]);
        }

        return ans.toString();
    }
}