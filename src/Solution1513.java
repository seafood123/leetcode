/*
 * 시작	:	21:20
 * 끝	:	21:27
 */
class Solution1513 {
	
    public int numSub(String s) {
        int mod = 1000000007;
    	int result = 0;
        
    	int count = 0;
    	int index = -1;
    	
    	while(++index < s.length()) {
    		if(s.charAt(index) == '0') count=0;
    		else {
    			count++;
    			result+=count;
    			if(result>mod) result %= mod;
    		}
    	}
    	
        return result;
    }
}