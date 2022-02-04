import java.util.HashMap;
import java.util.Map;

class Solution525 {
    public int findMaxLength(int[] nums) {
        if(nums.length <= 1) return 0;
        for(int i=0; i< nums.length; i++) {
            if(nums[i] == 0) nums[i] = -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int lastIndex = 0;
        int max=  0;
        for(int i=0; i< nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum)) {
                lastIndex = map.get(sum);
                max = Math.max(i-lastIndex, max);
            }else {
                map.put(sum, i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution525 s = new Solution525();
        s.findMaxLength(new int[]{0,0,1,0,0,0,1,1});
    }
}