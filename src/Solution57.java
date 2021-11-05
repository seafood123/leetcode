import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution57 {
	public static void main(String[] args) {
		insert(new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[] {4,8});
	}
    public  static int[][] insert(int[][] intervals, int[] newInterval) {
    	PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) return o1[1]-o2[1];
				return o1[0]-o2[0];
			} 
    	});
    	queue.add(newInterval);
    	for(int[] i : intervals) {
    		queue.add(i);
    	}
    	
    	ArrayList<int[]> list = new ArrayList<>();
    	int[] temp;
    	int[] now;
    	temp = queue.poll();
    	while(!queue.isEmpty()) {
    		
    		now = queue.poll();
    		
    		if(temp[1]>=now[0]) {
    			temp[1] = Math.max(temp[1],now[1]);
    		}else {
    			list.add(temp);
    			temp = now;
    		}
    		
    	}
    	list.add(temp);
    	
    	return list.toArray(new int[list.size()][2]);
    	
    }
}