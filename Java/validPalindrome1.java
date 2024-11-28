import java.util.*;
class Solution {
    public boolean isPalindrome(String s) {
        s= s.toLowerCase();

        s= s.replace(" ", "");
        String t1= "";
        String t2= "";

        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            if((c>='a' && c<='z')||(c>='0' && c<='9')){
                t1+=c;
            }
        }

        for(int i=t1.length()-1; i>=0; i--){
            t2+=t1.charAt(i);
        }

        System.out.println(t1);
        System.out.println(t2);

        return t1.equals(t2);
    }
}