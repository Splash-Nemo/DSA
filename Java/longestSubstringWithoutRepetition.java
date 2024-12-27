class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
            return 0;
        int ans= 1;

        char[] c= s.toCharArray();
        int n= c.length;
        int si=0, ei= 0;        

        HashSet<Character> check= new HashSet<>();

        while(ei<n && si<=ei){
            if(!check.contains(c[ei])){
                check.add(c[ei]);
                ei+=1;
            }else{
                ans= Math.max(ans, check.size());
                check.remove(c[si]);
                si+=1;
            }
        }

             
        return Math.max(ans, check.size());
    }
}