class Solution {
    public int maxProfit(int[] prices) {
        int pointer=0, profit= 0;

        for(int i=1; i<prices.length; i++){
            if(prices[i]>prices[pointer]){
                int p= prices[i]-prices[pointer];
                profit= Math.max(p, profit);
            }else if(prices[pointer]>=prices[i]){
                pointer= i;
            }
        }

        return profit;
    }
}