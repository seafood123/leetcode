import java.util.HashMap;

class Solution1461 {
	public static void main(String[] args) {
		hasAllCodes("00110",2);
	}
    public static boolean hasAllCodes(String s, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        int index = 0;
        while(index < s.length() && index+k <= s.length()) {
        	map.put(s.substring(index,index+k), 1);
        	index++;
        }
        
        if(map.size() == (int) Math.pow(2,k) ) return true;
        return false;
    }
}