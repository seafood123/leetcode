import java.util.Stack;

class Solution402 {
    public String removeKdigits(String num, int k) {
        if (k == 0) return num;
        if (num.length() == k) return "0";
        
        StringBuilder sb = new StringBuilder();
        
        Stack<Character> stack = new Stack();
        
        int index = 0;
        while (index < num.length()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(index)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(index++));
        }
        
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        
        String result = sb.toString();
        
        int zeroIndex = 0;
        while (zeroIndex < result.length() && result.charAt(zeroIndex) == '0') {
            zeroIndex++;
        }
        
        
        return result.substring(zeroIndex).equals("") ? "0" : result.substring(zeroIndex) ;
    }
    
    public static void main(String[] args) {
        Solution402 s = new Solution402();
        String str = s.removeKdigits("10200", 1);
        System.out.println(str);
    }
}