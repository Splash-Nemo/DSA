class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1; 
        int right = Arrays.stream(nums).max().getAsInt(); 

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (split(nums, maxOperations, mid)) {
                right = mid; 
            } else {
                left = mid + 1; 
            }
        }
        return left;
    }

    private static boolean split(int[] nums, int maxOperations, int maxBalls) {
        int operations = 0;
        for (int balls : nums) {
            if (balls > maxBalls) {
                operations += (balls - 1) / maxBalls;
            }
            if (operations > maxOperations) {
                return false;
            }
        }
        return true;
    }
}