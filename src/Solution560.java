import java.util.HashMap;

class Solution560 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum =0;
        int count = 0;
        int diff = 0;
        for (int n : nums) {
            sum += n;
            diff = sum - k;
            count += map.getOrDefault(diff, 0);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}