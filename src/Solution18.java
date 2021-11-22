import java.util.*;

class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int start = 0;
        int end = 0;
        int sum = 0;
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                sum = nums[i] + nums[j];
                start = j + 1;
                end = nums.length - 1;
                while (start < end) {
                    if (sum + nums[start] + nums[end] < target) {
                        start++;
                    } else if (sum + nums[start] + nums[end] > target) {
                        end--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[start++], nums[end--]));
                        while(start < nums.length && nums[start] == nums[start-1]) start++;
                        while(end > -1 && nums[end] == nums[end+1]) end--;
                    }
                }
                while(j+1<nums.length && nums[j] == nums[j+1]) j++;
            }
            while(i+1<nums.length && nums[i] == nums[i+1]) i++;
        }
        return result;
    }
}