import java.util.ArrayList;
import java.util.Stack;

class Solution1249 {
	public static class Node{
		int index;
		char str;
		public Node(int index, char str) {
			super();
			this.index = index;
			this.str = str;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [index=");
			builder.append(index);
			builder.append(", str=");
			builder.append(str);
			builder.append("]");
			return builder.toString();
		}
		
	}
	/*
    public String minRemoveToMakeValid(String s) {
        Stack<Node> stack = new Stack();
        ArrayList<Node> removeList = new ArrayList<>();
        char c;
        for(int i =0 ; i<s.length();i++) {
        	c = s.charAt(i);
        	if(c == '(') {
        		stack.add(new Node(i, '('));
        	}else if(c == ')') {
        		if(stack.isEmpty() || stack.peek().str != '(') {
        			removeList.add(new Node(i,')'));
        		}else {
        			if(!stack.isEmpty()) stack.pop();
        		}
        	}
        }
        
        while(!stack.isEmpty()) {
        	removeList.add(stack.pop());
        }
        
        char[] array = s.toCharArray();
        
        for(Node n : removeList) {
        	array[n.index] = '0';
        }
        
        StringBuffer sb = new StringBuffer();
        for(char a : array) {
        	if(a!='0') sb.append(a);
        }
        
        return sb.toString();
    } */
	
	public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack();
        char c;
        char[] array = s.toCharArray();
        for(int i =s.length()-1 ; i>=0;i--) {
        	c = array[i];
        	if(c == ')') {
        		stack.add(i);
        	}else if(c == '(') {
        		if(stack.isEmpty() || array[stack.peek()] == '(') {
        			stack.add(i);
        		}else {
        			if(!stack.isEmpty()) stack.pop();
        		}
        	}
        }
        
        
        StringBuffer sb = new StringBuffer();
        
        for(int i=0;i<array.length;i++) {
        	if(!stack.isEmpty() && stack.peek()==i) {
        		stack.pop();
        	}else {
        		sb.append(array[i]);
        	}
        }
        
        return sb.toString();
	}
}