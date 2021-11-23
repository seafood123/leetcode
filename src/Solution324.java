import java.util.Arrays;

class Solution324 {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0) return;
        Arrays.sort(nums);
        int[] copyValue = Arrays.copyOf(nums, nums.length);

        int left = 0;
        int right = nums.length-1;
        int index = 0;
        while(left < right && copyValue[left] != copyValue[right]) {
            nums[index++] = copyValue[left++];
            nums[index++] = copyValue[right--];
        }

        for(int i= index; i<nums.length; i++) {
            nums[i] = copyValue[left];
        }

        int odd = 0;
        while(index < nums.length) {
            swap(nums, index, odd);
            odd += 2;
            index += 2;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution324 solution324 = new Solution324();
        int[] result = new int[]{1,3,1,3,2,2};
        solution324.wiggleSort(result);
        System.out.println(Arrays.toString(result));
    }
}