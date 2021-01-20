class Solution978 {
	
	public static void main(String[] args) {
		maxTurbulenceSize(new int[] {9,4,2,10,7,8,8,1,9});
	}
	public static int maxTurbulenceSize(int[] arr) {
		int max = 1;
//		int up = 1;
//		int down = 1;
//		if(arr.length == 1) return 1;
//		for(int i=1;i<arr.length;i++) {
//			if(arr[i] > arr[i-1]) {
//				// up
//				
//				up = 1 + down;
//				down = 1;
//				max = Math.max(max, up);
//				
//			}else if(arr[i] < arr[i-1]) {
//				
//				down = 1 + up;
//				up = 1;
//				max = Math.max(max, down);
//				
//			}else {
//				up = 1;
//				down = 1;
//			}
//		}
		int s = 0;
		
		int i = 1;
		
		for(;i<arr.length-1;i++) {
			if(arr[i-1]==arr[i]) {
				s = i;
				continue;
			}
			
			if(arr[i-1]<arr[i] && arr[i+1]<arr[i]) continue;
			if(arr[i+1]>arr[i] && arr[i-1]>arr[i]) continue;
			
			max = Math.max(max, i-s+1);
			s = i;
		}
		
		if(arr[i-1]!=arr[i]) max = Math.max(max,  i-s+1);
		
		return max;
	}
}