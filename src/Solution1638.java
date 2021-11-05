import java.util.Arrays;

class Solution1638 {
	public static void main(String[] args) {
		countSubstrings("abe", "bbc");
	}
    public static int countSubstrings(String s, String t) {
        
    	int cnt = 0;
    	
    	int[][] flag = new int[s.length()][t.length()];
    	
    	char sChar;
    	
    	String s1 = "";
    	String s2 = "";
    	
    	if(s.length() >= t.length()) {
    		s1 = t;
    		s2 = s;
    	}else {
    		s1 = s;
    		s2 = t;
    	}
    	
    	for(int i=0;i<s1.length();i++) {
    		sChar = s1.charAt(i);
    		for(int j=0;j<s2.length();j++) {
    			if(s2.charAt(j) == sChar) {
    				flag[i][j] = 0;
    			}
    			else {
    				flag[i][j] = 1;
    			}
    		}
    	}
    	
    	
    	
    	int row = 0;
    	int col = 0;
    	int count = 0;
    	for(int r = 0; r<flag[0].length;r++) {
    		for(int c = 0; c<flag[1].length;c++) {
    			count = 0;
        		
        		row = r;
        		col = c;
        		
        		while(count<=1 && row < s1.length() && col < s2.length()) {
        			//System.out.println(row + ","+col);
        			count += flag[row][col];
        			row++;
        			col++;
        			if(count==1) cnt++;
        		}
        		//System.out.println();
    		}
    	}
    	
    	//System.out.println(cnt);
    	
    	return cnt;
    }
}