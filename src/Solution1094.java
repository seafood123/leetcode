import java.util.Comparator;
import java.util.PriorityQueue;

class Solution1094 {
    public static class Bus {
        int passengers;
        int from;
        int to;
        public Bus(int passengers, int from, int to) {
            this.passengers = passengers;
            this.from = from;
            this.to = to;
        }
    }

    public boolean carPooling(int[][] trips, int capacity) {
        int[] position = new int[1001];
        for(int[] trip: trips) {
            position[trip[1]] += trip[0];
            position[trip[2]] -= trip[0];
        }
        int passenger = 0;
        for(int i=0; i<position.length; i++) {
            passenger += position[i];
            if(passenger > capacity) return false;
        }
        return true;
    }

    public boolean carPooling1(int[][] trips, int capacity) {
        PriorityQueue<Bus> fromPQ = new PriorityQueue<>((o1, o2) -> o1.from - o2.from);
        PriorityQueue<Bus> toPQ = new PriorityQueue<>((o1, o2) -> o1.to - o2.to);

        for(int[] trip : trips) {
            fromPQ.add(new Bus(trip[0], trip[1], trip[2]));
            toPQ.add(new Bus(trip[0], trip[1], trip[2]));
        }
        int remain = 0;
        int toPeek = 0;
        while(!fromPQ.isEmpty() && !toPQ.isEmpty()) {
            toPeek = toPQ.peek().to;
            while(!fromPQ.isEmpty() && fromPQ.peek().from < toPeek) {
                remain += fromPQ.poll().passengers;
            }
            if(remain > capacity) return false;
            while(!toPQ.isEmpty() && toPQ.peek().to == toPeek) {
                remain -= toPQ.poll().passengers;
            }
        }
        return true;
    }
}