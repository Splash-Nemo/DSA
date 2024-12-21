class KthLargest {
    PriorityQueue<Integer> abc;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k= k;
        this.abc= new PriorityQueue<>(k);

        for(int i: nums){
            add(i);
        }
    }
    
    public int add(int val) {
        if(abc.size()<k){
            abc.add(val);
        }else if(val>abc.peek()){
            abc.poll();
            abc.add(val);
        }

        return abc.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */