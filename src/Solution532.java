import java.util.Arrays;

class Solution532 {
    // 단순한방법 1.
    /*public int findPairs(int[] nums, int k) {
        // 우선 정렬한다.. 오름차순
        Arrays.sort(nums);
    
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        int count = 0;
        int beforeNum = -987654321;
        
        for(int i : nums) {
            map.put(i, map.get(i)-1);
            if(i == beforeNum) continue;
            beforeNum = i;
            count += map.getOrDefault(i+k, 0) != 0 ? 1 : 0;
        }
        return count;
    }*/
    public int findPairs(int[] nums, int k) {
        // 우선 정렬한다.. 오름차순
        Arrays.sort(nums);
        
        int back = 0;
        int front = 1;
        int diff = 0;
        int count = 0;
        while(back < nums.length && front < nums.length) {
            diff = nums[front] - nums[back];
            if(diff < k) {
                front++;
            }else if(diff > k) {
                back++;
                if(front == back) front++;
            }else {
                count++;
                front++;
                back++;
                while(front < nums.length && nums[front-1] == nums[front]) {
                    front++;
                }
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        Solution532 s = new Solution532();
        int result = s.findPairs(new int[]{1,1,1,1,1,1}, 0);
        System.out.println(result);
    }
}