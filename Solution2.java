class Solution2 {
	public static void main(String[] args) {
		System.out.println(solution("ffffffff"));
	}
    public static int solution(String s) {
        
        int len = s.length();
        int answer = s.length();
        String cut = "";
        int index = 0;
        boolean flag = true;
        
        for(int i=1;i<=answer/2;i++) {
        	if(answer % i != 0) continue;
        	cut = s.substring(0,i);
        	index = i;
        	
        	flag = true;
        	while(index +i <= answer) {
        		if(!s.substring(index,index+i).equals(cut)) {
        			flag = false;
        			break;
        		}
        		index += i;
        	}
        	
        	if(flag) {
        		return cut.length();
        	}
        	
        	
        	
        }
        
        
        
        return answer;
    }
}