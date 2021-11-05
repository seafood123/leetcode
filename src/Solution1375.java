class Solution1375 {
	public static void main(String[] args) {
		numTimesAllBlue(new int[] {2,4,1,3,5,6});
	}
    public static int numTimesAllBlue(int[] light) {
        int count = 0;
        int blue = 0;
        int yellow = 0;
        int[] bulb = new int[light.length+1];
        // 0 : off , 1 : blue, 2: yellow
        for(int i:light) {
        	
        	bulb[i] = 2;
        	yellow++;
        	if(blue+1 == i) {
        		bulb[i] = 1;
        		blue++;
        		yellow--;
        		while(blue<light.length && bulb[blue+1]!=0) {
        			if(bulb[blue+1]==2) {
        				yellow --;
        				bulb[blue+1] = 1;
        			}
        			blue++;
        		}
        	}
        	
        	if(yellow==0) count++;
        	
        }
        return count;
    }
}