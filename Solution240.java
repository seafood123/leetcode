

class Solution240 {
	
    public static boolean searchMatrix(int[][] matrix, int target) {
    	
    	int row = 0;
    	int col = matrix[0].length;
    	
    	while(row >= 0 && row < matrix.length && col >=0 && col<matrix.length) {
    		if(matrix[row][col] > target) {
    			col--;
    		}else if(matrix[row][col]<target) {
    			row++;
    		}else {
    			return true;
    		}
    	}
    	
    	return false;
    }
}