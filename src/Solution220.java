import java.util.ArrayList;
import java.util.Collections;

class Solution220 {
	public static class Node implements Comparable<Node>{
		int value;
		int index;
		public Node(int value, int index) {
			super();
			this.value = value;
			this.index = index;
		}
		@Override
		public int compareTo(Node o) {
			return this.value - o.value;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [value=");
			builder.append(value);
			builder.append(", index=");
			builder.append(index);
			builder.append("]");
			return builder.toString();
		}
		
		
		
	}
	public static void main(String[] args) {
		System.out.println(containsNearbyAlmostDuplicate(new int[] {1, 3,6,2},1,2));
	}
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	long now = 0;
    	long next = 0;
    	int index = 0;
    	ArrayList<Node> list = new ArrayList<>();
    	for(int i : nums) {
    		list.add(new Node(i,index++));
    	}
    	
    	Collections.sort(list);
    	
        for(int i=0;i<list.size();i++) {
        	now = list.get(i).value;
        	System.out.println("Now " + list.get(i).toString());
        	for(int j=i+1; j<list.size();j++) {
        		next = list.get(j).value;
        		System.out.println(list.get(j).toString());
        		if(Math.abs((long) (next - now)) > t) break;
        		if(Math.abs(list.get(j).index - list.get(i).index) <= k) return true;
        	}
        	
        	
        }
        return false;
    }
}