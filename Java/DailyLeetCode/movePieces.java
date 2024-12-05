class Solution {
    public boolean canChange(String start, String target) {

        int n = start.length();
        char[] st = start.toCharArray();
        char[] tar = target.toCharArray();

        int i = 0, j = 0;

        while (i < n && j < n) {
            while (i < n && tar[i] == '_') 
                i++;
            while (j < n && st[j] == '_') 
                j++;

            if (i == n || j == n) {
                return i == n && j == n;
            }

            if (st[j] != tar[i]) 
            return false;

            if (tar[i] == 'L') {
                if (j < i) return false; 
            } else if (tar[i] == 'R') {
                if (i < j) return false;
            }

            i++;
            j++;
        }
        return i == n && j == n;
    }
}
