import java.util.*;
class Solution {
    public boolean isValid(String s) {

        if(s.length()==1 || s.charAt(0)==')' || s.charAt(0)=='}' || s.charAt(0)==']')
        return false;

        Stack<Character> open= new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                open.push(c);
            }else if(c==')' || c=='}' || c==']'){
                if(open.size()>0 && open.peek()=='(' && c==')')
                open.pop();
                else if(open.size()>0 && open.peek()=='{' && c=='}')
                open.pop();
                else if(open.size()>0 && open.peek()=='[' && c==']')
                open.pop();
                else
                return false;
            }
        }

        return open.size()==0;
    }
}