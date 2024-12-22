class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int[] nextGreater = NG(heights, n);
        
        int m = queries.length;
        int[] ans = new int[m];
        for(int i = 0; i < m; i++){
            int max = Math.max(queries[i][0], queries[i][1]);
            int min = Math.min(queries[i][0], queries[i][1]);
            if(max == min){  
                ans[i] = max;
                continue;
            }
            if(heights[max] > heights[min]){ 
                ans[i] = max;
            }else{
                if(nextGreater[max] == -1){
                            ans[i] = -1;       
                }else{
                    boolean find = false;
                    while(!find){
                        int next = nextGreater[max];
                        if(next == -1){
                            ans[i] = -1;
                            find = true;
                            break;
                        }
                        if(heights[next] > heights[min]){
                            ans[i] = next;
                            find = true;
                        }else{
                            max = next;
                        }
                    }  
                } 
            }
        }
        return ans;
    }
    public int[] NG(int[] heights, int n){
        int[] nextGreater = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!s.isEmpty() && heights[s.peek()] < heights[i]){
                int j = s.pop();
                nextGreater[j] = i;
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int j = s.pop();
            nextGreater[j] = -1;
        }
        return nextGreater;
    }
}