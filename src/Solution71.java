import java.util.Stack;

class Solution71 {
	public static void main(String[] args) {
		simplifyPath("/home//foo/");
	}
    public static String simplifyPath(String path) {
    	String[] arr = path.split("/");
    	Stack<String> stack = new Stack<>();
    	
    	for(String s : arr) {
    		if(s.equals("")) continue;

    		if(s.equals(".")) continue;

    		if(s.equals("..")) {
    			if(!stack.isEmpty()) {
    				stack.pop();
				}
				continue;
			}
    		
    		stack.add(s);
    		
    	}

    	StringBuilder sb = new StringBuilder();
    	String s = "";
    	while(!stack.isEmpty()) {
    		s = stack.pop();
    		sb.insert(0, "/"+s);
    	}
    	if(sb.length()==0) sb.append("/");
    	System.out.println(sb.toString());
    	return sb.toString();
    }
}