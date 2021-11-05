import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution295 {
    public static class MedianFinder {
        PriorityQueue<Integer> minQueue;
        PriorityQueue<Integer> maxQueue;
        boolean even = true;
        public MedianFinder() {
            minQueue = new PriorityQueue<>();
            maxQueue = new PriorityQueue<>((v1,v2) -> v2-v1);
            even = true;
        }

        public void addNum(int num) {
            if(even) {
                maxQueue.add(num);
                minQueue.add(maxQueue.poll());
            }else {
                minQueue.add(num);
                maxQueue.add(minQueue.poll());
            }
            even = !even;
        }

        public double findMedian() {
            if(even) {
                return ((double) maxQueue.peek() + (double) minQueue.peek()) / 2.0;
            }else {
                return (double) minQueue.peek();
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

}
