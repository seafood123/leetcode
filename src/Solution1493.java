import java.util.Arrays;

/*
 * 시작	: 	22시 35분 
 * 끝	:	22시 56분
 * 
 */

class Solution1493 {
	public static void main(String[] args) {
		System.out.println(longestSubarray(new int[] {1,1,1,1}));
	}
    public static int longestSubarray(int[] nums) {
        int numberOneCount = 0;
        int numberZeroCount = 0;
    	for(int i:nums) {
    		if(i==1) numberOneCount++;
    		else numberZeroCount++;
    	}
    	
    	if(numberOneCount == nums.length) {
    		return nums.length-1;
    	}else if(numberZeroCount == nums.length) {
    		return 0;
    	}
    	
    	int[] front = new int[nums.length];
        int[] back = new int[nums.length];
        
        
        
        front[0] = (nums[0]==0)? 0:1;
        back[nums.length-1] = (nums[nums.length-1]==0)? 0:1;
        
       for(int i=1;i<nums.length;i++) {
    	   if(nums[i]==1) {
    		   if(nums[i-1]==1) {
    			   front[i] = front[i-1]+1;
    		   }else {
    			   front[i] = 1;
    		   }
    	   }else {
    		   if(nums[i-1]==1) {
    			   front[i] = front[i-1];
    		   }else {
    			   front[i] = 0;
    		   }
    	   }
       }
       
       for(int i=nums.length-2;i>=0;i--) {
    	   if(nums[i]==1) {
    		   if(nums[i+1]==1) {
    			   back[i] = back[i+1]+1;
    		   }else {
    			   back[i] = 1;
    		   }
    	   }else {
    		   if(nums[i+1]==1) {
    			   back[i] = back[i+1];
    		   }else {
    			   back[i] = 0;
    		   }
    	   }
       }
       int result = 0;
       for(int i=0;i<nums.length;i++) {
    	   if(nums[i]==0) {
    		   result = Math.max(result, front[i]+back[i]);
    	   }
       }
       
       
       System.out.println(Arrays.toString(front));
       System.out.println(Arrays.toString(back));
       return result;
    }
}