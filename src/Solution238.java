import java.util.Arrays;

class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        long multiple = 1;
        int zeroCount = 0;
        int zeroIndex = 0;


        for(int i =0; i<len; i++) {
            if(nums[i] == 0) {
                zeroCount++;
                zeroIndex = i;
            } else {
                multiple *= nums[i];
            }
        }

        if(zeroCount > 1) {
            return result;
        } else if (zeroCount == 1) {
            result[zeroIndex] = (int) multiple;
        } else {
            for(int i=0;i<len;i++){
                result[i] = (int) (multiple / nums[i]);
            }
        }
        return result;
    }
}