class Solution55 {
    public boolean canJump(int[] nums) {
       /* # 1.
        int len = nums.length;
        if(len <= 1) return true;
        int[] jump = new int[len];

        jump[0] = nums[0];
        if(nums[0] == 0) return false;
        for(int i=1;i<len;i++) {
            jump[i] = Math.max(jump[i-1]-1, nums[i]);
            if(jump[i] == 0 && i != len-1) return false;
        }
        return true;*/

        int len = nums.length;
        int prev = len-1;

        for(int i=prev-1; i>=0; i--) {
            if(nums[i] + i >= prev) prev = i;
        }

        if(prev <= 0) return true;
        return false;
    }
}