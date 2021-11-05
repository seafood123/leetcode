import java.util.HashMap;
import java.util.Stack;

class Solution316 {
	public static void main(String[] args) {
		System.out.println(removeDuplicateLetters("cbacdcbc"));
	}
    public static String removeDuplicateLetters(String s) {
    	
    	HashMap<Character, Integer> map = new HashMap<>();
    	boolean[] flag = new boolean[27];
    	
    	for(int i=s.length()-1;i>=0;i--) {
    		if(!map.containsKey(s.charAt(i))) {
    			map.put(s.charAt(i), i);
    		}
    	}
    	char now;
    	Stack<Character> stack = new Stack<>();
    	for(int i = 0; i< s.length();i++) {
    		now = s.charAt(i);
    		
    		if(!flag[now-'a']) {
    			while(!stack.isEmpty() && stack.peek() > now && map.get(stack.peek()) > i) {
    				flag[stack.pop()-'a'] = false;
    			}
    			
    			flag[now-'a'] = true;
    			stack.push(now);
    		}
    		
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	
    	while(!stack.isEmpty()) {
    		sb.append(stack.pop());
    	}
    	
    	return sb.reverse().toString();
    	
    }
}