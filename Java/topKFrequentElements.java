class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map= new HashMap<>();
        PriorityQueue<int[]> pr= new PriorityQueue<>((a,b)->a[0]-b[0]);

        for(int i:nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        int last= 0;
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            pr.add(new int[]{e.getValue(), e.getKey()});
            if(pr.size()>k){
                pr.poll();
            }
        }

        int[] ans= new int[k];
        int x=0;

        while(pr.size()>0){
            ans[x++]= pr.poll()[1];
        }

        return ans;
    }
}