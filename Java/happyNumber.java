class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> abc= new HashSet<>();
        while(n!=1 && !abc.contains(n)){
            int k= n;
            int sum= 0;

            while(k>0){
                sum+= Math.pow(k%10,2);
                k/=10;
            }
            System.out.println(sum);
            abc.add(n);
            n=sum;
        }

        return n==1;
    }
}