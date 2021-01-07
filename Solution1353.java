import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution1353 {
    public int maxEvents(int[][] events) {
    	PriorityQueue<Integer> queue = new PriorityQueue<>();
    	
    	Arrays.sort(events,new Comparator<>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
    		
    	});
    	
    	int index = 0;
    	int day = 0;
    	int attend = 0;
    	
    	while(index < events.length || !queue.isEmpty()) {
    		if(queue.isEmpty()) {
    			queue.add(events[index][1]);
    			day = events[index++][0];
    		}
    		while(index<events.length && events[index][0] <= day ) {
    			queue.add(events[index++][1]);
    		}
    		if(queue.peek() >= day) {
    			attend++;
    			day++;
    		}
    		queue.poll();
    	}
    	
    	return attend;
    };
}