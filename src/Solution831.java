import java.util.HashSet;
import java.util.Set;

class Solution831 {
	public static void main(String[] args) {
		System.out.println(maskPII("86-(10)12345678"));
	}
    public static String maskPII(String S) {
        S = S.toLowerCase();
        String name1 = "";
        
        StringBuffer sb = new StringBuffer();
        
        Set<String> set = new HashSet<>(); 
        
        set.add("(");
        set.add(")");
        set.add("");
        set.add(" ");
        set.add("-");
        set.add("+");
        
        int len = 0;
        
        if(S.indexOf("@")!=-1) {
        	name1 = S.split("\\@")[0];
        	sb.append(name1.charAt(0));
        	sb.append("*****");
        	sb.append(name1.charAt(name1.length()-1)+"@");
        	sb.append(S.split("\\@")[1]);
        }else {
        	String s = "";
        	for(char c : S.toCharArray()) {
        		if(set.contains(c+"")) continue;
        		s+=c+"";
        	}
        	
        	for(int i=s.length()-1;i>=0;i--) {
        		if(len>=4) {
        			sb.insert(0, "*");
        		}else {
        			sb.insert(0, s.charAt(i));
        		}
        		len++;
        		if(len==4 || len==7 || (len==10 && s.length()>10)) {
        			sb.insert(0,"-");
        		}
        	}
        	if(s.length()>10) sb.insert(0,"+");
        	
        }
        return sb.toString();
    }
}