class Solution {
    public boolean isPalindrome(String s) {
        s= s.toLowerCase();
        s= s.replace(" ", "");
        int n= s.length();
        int si=0, ei=n-1;

        while(si<ei){
            System.out.println(s.charAt(si)+ " "+ s.charAt(ei));
            if(!Character.isLetterOrDigit(s.charAt(si)))
                si+=1;
            else if(!Character.isLetterOrDigit(s.charAt(ei)))
                ei-=1;
            else{
                if(s.charAt(si)!=s.charAt(ei)){
                    return false;
                }
                si+=1;
                ei-=1;
            }
        }

        return true;
    }
}