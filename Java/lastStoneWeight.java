class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: stones){
            maxHeap.add(i);
        }

        while(maxHeap.size()>1){
            int l= maxHeap.poll();
            int r= maxHeap.poll();

            int ans= Math.abs(l-r);
            maxHeap.add(ans);
        }

        if(maxHeap.size()==1)
            return maxHeap.peek();
        
        return 0;
    }
}