import java.util.HashSet;
import java.util.Stack;

class Solution150 {
	public static void main(String[] args) {
		System.out.println(evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
	}
    public static int evalRPN(String[] tokens) {
    	if(tokens.length == 0) return 0;
    	if(tokens.length == 1) return Integer.parseInt(tokens[0]);
    	
    	Stack<String> stack = new Stack<>();
    	
    	HashSet<String> set = new HashSet<>();
    	
    	set.add("+");
    	set.add("-");
    	set.add("*");
    	set.add("/");
    	
    	int second = 0;
    	int first = 0;
    	
    	for(String s : tokens) {
    		
    		if(set.contains(s)) {
    			
    			second = Integer.parseInt(stack.pop());
    			first = Integer.parseInt(stack.pop());
    			
    			stack.add(calculate(first,second,s)+"");
    			
    		}else {
    			stack.add(s);
    		}
    		
    	}
    	
    	return Integer.parseInt(stack.pop());
    			
    			
    	
    }
    
    public static int calculate(int first , int second, String sym) {
    	switch(sym) {
    	case "+" :
    		return first + second;
    	case "-":
    		return first - second;
    	case "*":
    		return first * second;
    	case "/":
    		return first / second;
    	}
    	return 0;
    }
}