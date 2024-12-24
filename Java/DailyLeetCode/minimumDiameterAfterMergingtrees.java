class Solution {
    int maxD;

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int n1 = edges1.length + 1, n2 = edges2.length + 1;
        ArrayList<Integer>[] t1 = new ArrayList[n1];
        ArrayList<Integer>[] t2 = new ArrayList[n2];

        for (int i = 0; i < n1; i++) t1[i] = new ArrayList<>();
        for (int i = 0; i < n2; i++) t2[i] = new ArrayList<>();
        
        for (int[] e : edges1) {
            t1[e[0]].add(e[1]);
            t1[e[1]].add(e[0]);
        }
        for (int[] e : edges2) {
            t2[e[0]].add(e[1]);
            t2[e[1]].add(e[0]);
        }
        
        maxD = -1;
        boolean[] vis1 = new boolean[n1];
        calcDiam(0, t1, vis1);
        int d1 = maxD;

        maxD = -1;
        boolean[] vis2 = new boolean[n2];
        calcDiam(0, t2, vis2);
        int d2 = maxD;

        int candDiam = (d1 + 1) / 2 + (d2 + 1) / 2 + 1;
        return Math.max(candDiam, Math.max(d1, d2));
    }

    private int calcDiam(int node, ArrayList<Integer>[] t, boolean[] vis) {
        vis[node] = true;
        int maxH = -1, secMaxH = -1;

        for (int child : t[node]) {
            if (!vis[child]) {
                int h = calcDiam(child, t, vis);
                if (h > maxH) {
                    secMaxH = maxH;
                    maxH = h;
                } else if (h > secMaxH) {
                    secMaxH = h;
                }
            }
        }
        
        maxD = Math.max(maxD, maxH + secMaxH + 2);
        return maxH + 1;
    }
}
