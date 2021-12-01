class Solution213 {
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][1] = nums[0];
        int zeroStart = 0;
        for(int i=1;i < nums.length-1; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }

        zeroStart = Math.max(dp[nums.length-2][0], dp[nums.length-2][1]);

        int oneStart = 0;
        dp = new int[nums.length][2];
        dp[1][1] = nums[1];

        for(int i=2; i<nums.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }

        oneStart = Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);

        return Math.max(zeroStart, oneStart);
    }
}