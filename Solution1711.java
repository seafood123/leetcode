import java.util.HashMap;

class Solution1711 {
	public static void main(String[] args) {
		System.out.println(countPairs(new int[] {1,2}));
	}
    public static int countPairs(int[] deliciousness) {
        int mod = 1000000007;
    	int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
   
    	for(int d : deliciousness) {
    		for(int i=1;i<Math.pow(2, 22);i*=2) {
    			if(i-d <0) continue;
    			res += map.getOrDefault(i-d, 0);
    			res %= mod;
    		}
    		map.put(d, map.getOrDefault(d,0)+1);
    	}
    	return res;
    	
    }
}