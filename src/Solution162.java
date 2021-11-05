
public class Solution162 {
    public int findPeakElement(int[] nums) {
        int s = 0;
        int e = nums.length-1;
        int mid = 0;
        while(s<e) {
            mid = (s+e)/2;
            if(nums[mid] > nums[mid+1]) {
                e = mid;
            } else {
                s = mid+1;
            }
        }
        return s;
    }
}
