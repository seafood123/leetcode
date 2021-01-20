class Solution1701 {
    public double averageWaitingTime(int[][] customers) {
        int[] wait = new int[customers.length];
        
        int time = 0;
        
        int index = 0;
        
        for(int[] i : customers) {
        	if(time < i[0]) {
        		time = i[0]+i[1];
        		wait[index] = time-i[0];
        	}else {
        		time = time + i[1];
        		wait[index] = time - i[0];
        	}
        	index++;
        }
        
        double sum = 0;
        
        for(int i : wait) {
        	sum += (double) i;
        }
        
        return sum/wait.length;
        
    }
}