/*
 * 시작	: 20 : 35 
 * 끝	: 20 : 57 	
 */
import java.util.Arrays;

class Solution1653 {
	public static void main(String[] args) {
		int s = minimumDeletions("aababbab");
		System.out.println(s);
	}
    public static int minimumDeletions(String s) {
    	int result = Integer.MAX_VALUE;
    	
    	int[] a = new int[s.length()];
    	int[] b = new int[s.length()];
    	
    	int aCount = 0;
    	int bCount = 0;
    	char[] arr = s.toCharArray();
    	int index = s.length()-1;
    	
    	while(index >= 0) {
    		if(arr[index] == 'a') {
    			a[index] = aCount++;
    		}else {
    			a[index] = aCount;
    		}
    		index--;
    	}
    	index = 0;
    	while(index < s.length()) {
    		if(arr[index] == 'b') {
    			b[index] = bCount++;
    		}else {
    			b[index] = bCount;
    		}
    		if(result > a[index]+b[index]) result = a[index]+b[index];
    		index++;
    	}
    	
    	return result;
    }
}