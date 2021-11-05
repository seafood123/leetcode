import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution49 {
	public static void main(String[] args) {
		groupAnagrams(new String[] {"stop","pots","reed","","tops","deer","opts",""});
	}
    public static List<List<String>> groupAnagrams(String[] strs) {
    	List<List<String>> result = new ArrayList<>();
    	HashMap<String, List<String>> map = new HashMap<>();
    	List<String> list;
    	char[] c;
    	String newStr;
    	for(String s : strs) {
    		c = s.toCharArray();
    		Arrays.sort(c);
    		
    		newStr = new String(c);
    		
    		if(!map.containsKey(newStr)) map.put(newStr, new ArrayList<String>());
    		
    		list = map.get(newStr);
    		
    		list.add(s);
    		
    	}
    	result = new ArrayList<>(map.values());
    	return result;
    }	
    
}