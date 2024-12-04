import java.util.*;
class Solution1 {
    public int hammingWeight(int n) {
        HashMap<Integer,Integer> abc= new HashMap<>();
        while(n>0){
            if(n%2==1)
                abc.put(n%2, abc.getOrDefault(n%2, 1)+1);
            
            n/=2;
        }

        return abc.get(1)-1;
    }
}

class Solution2 {
    public int hammingWeight(int n) {
        int count= 0;
        while(n!=0){
            count+= n & 1;
            n>>>=1;
        }

        return count;
    }
}