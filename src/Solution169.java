import java.util.Arrays;

class Solution169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    
    public static void main(String[] args) {
        Solution169 s  = new Solution169();
        int ss = s.majorityElement(new int[]{-1,100,2,100,100,4,100});
        System.out.println(ss);
        
    }
}