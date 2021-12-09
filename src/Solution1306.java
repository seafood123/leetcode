import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution1306 {
    public boolean canReach(int[] arr, int start) {
        if(arr[start] == 0) return true;
        if(arr[start] < 0) return false;
        int value = arr[start];
        arr[start] = -arr[start];
        if(start + value < arr.length && canReach(arr, start + value)) return true;
        if(start - value >= 0 && canReach(arr, start-value)) return true;
        return false;
    }
    public boolean canReachQueue(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(arr[start]);
        Set<Integer> set = new HashSet<>();
        set.add(start);

        int len = arr.length;
        int now = 0;
        while(!queue.isEmpty()) {
            now = queue.poll();
            if(arr[now] == 0) return true;
            if(now + arr[now] < len && !set.contains(now + arr[now])) {
                queue.add(now + arr[now]);
                set.add(now + arr[now]);
            }
            if(now - arr[now] >= 0 && !set.contains(now - arr[now])) {
                queue.add(now - arr[now]);
                set.add(now - arr[now]);
            }
        }
        return false;
    }

}