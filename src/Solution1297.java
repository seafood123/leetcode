/*
 * 시작 	: 19 : 37 
 * 끝	: 20 : 10 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution1297 {
	
	public static void main(String[] args) {
		System.out.println(maxFreq("",7,4,23));
	}
	
	public static Map<String, Integer> map;
	public static int result;
    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
    	result = 0;
    	map = new HashMap<>();
    	Set<String> set = new HashSet<>();
    	for(int i =0; i<s.length();i++) {
    		set = new HashSet<>();
    		searchString(set, "", i, 0, maxLetters, minSize, maxSize, s);
    	}
    	
    	List<Integer> valueSet = new ArrayList<>(map.values());
    	Collections.sort(valueSet,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
    		
    	});
    	
    	return valueSet.get(0);
    }
    
    public static void searchString(Set<String> set, String str, int index, int count, int maxLetters, int minSize, int maxSize, String s) {
    	if(set.size() > maxLetters) return;
    	if(count > maxSize ) return;
    	
    	if(count == minSize && !str.equals("")) {
    		map.put(str, map.getOrDefault(str, 0)+1);
    		return;
    	}
    	
    	if(index >= s.length()) return;
    	
    	set.add(s.charAt(index)+"");
    	String next = str + s.charAt(index);
    	searchString(set, next, index+1, count+1, maxLetters, minSize, maxSize, s);
    	
    }
}