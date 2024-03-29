class Solution35 {
    public int searchInsert(int[] nums, int target) {
        return find(0, nums.length-1, nums, target);
    }

    public int find(int start, int end, int[] nums, int target) {
        if(start > end) return start;
        int mid = (start + end) / 2;
        int result = 0;
        if(nums[mid] > target) {
            return find(start, mid-1, nums, target);
        }else if(nums[mid] < target) {
            return find(mid+1, end, nums, target);
        }else {
            return mid;
        }
    }
}