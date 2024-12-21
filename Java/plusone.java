// Using Linkedlist
class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val= val;
    }
    ListNode(int val, ListNode next){
        this.val= val;
        this.next= next;
    }
}

class Solution {
    public int[] plusOne(int[] digits) {
        int n= digits.length;
        ListNode abc= new ListNode(digits[n-1]);
        ListNode temp= abc;

        for(int i=n-2; i>=0; i--){
            ListNode newNode= new ListNode(digits[i]);
            temp.next= newNode;
            temp= newNode;
        }

        temp= abc;
        int carry= 1, size=n;

        while(carry==1){
            temp.val+=carry;
            if(temp.val>=10){
                carry=1;
                temp.val%=10;
            }else{
                carry=0;
            }
            if(temp.next!=null){
                temp= temp.next;
            }else{
                break;
            }
        }

        if(carry==1){
            ListNode newNode= new ListNode(1);
            temp.next= newNode;
            temp= newNode;
            size+=1;
        } 

        int[] ans= new int[size];
        for(int i=size-1; i>=0 && abc!=null; i--){
            ans[i]= abc.val;
            abc= abc.next;
        }

        return ans;
    }
}

// Using Math
class Solution {
    public int[] plusOne(int[] digits) {

        int n= digits.length;

        for(int i=n-1; i>=0; i--){
            if(digits[i]+1!=10){
                digits[i]+=1;
                return digits;
            }
            digits[i]=0;
        }

        int[] ans= new int[n+1];
        ans[0]=1;

        return ans;
    }
}