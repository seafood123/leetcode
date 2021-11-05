import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution6 {
	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING",3));
	}
    public static String convert(String s, int numRows) {
    	
    	HashMap<Integer, String> map = new HashMap<>();
    	
    	int r = -1;
    	String str = "";
    	boolean flag = false;
    	for(char c: s.toCharArray()) {
    		str = c+"";
    		
    		if(r<=0 && !flag) {
    			flag = true;
    		}
    		
    		if(flag) {
    			r++;
    			map.put(r, map.getOrDefault(r, "")+str);
    		}else {
    			r--;
    			map.put(r, map.getOrDefault(r, "")+str);
    		}
    		
    		if(r>=numRows-1 && flag) {
    			flag = !flag;
    			r = numRows - 1;
    		}
    		
    	}
    	
    	List<String> list = new ArrayList<>(map.values());
    	String result = "";
    	for(String st : list) {
    		result+=st;
    	}
    	return result;
    }
    
    
}