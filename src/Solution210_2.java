import java.util.*;

class Solution210_2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] count = new int[numCourses];
        int[] arr;
        List<Integer> preList;
        for(int i=0; i< prerequisites.length; i++) {
            arr = prerequisites[i];
            preList = map.getOrDefault(arr[0], new ArrayList<>());
            preList.add(arr[1]);
            map.put(arr[0], preList);
            count[arr[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i< count.length; i++) {
            if(count[i] == 0) queue.add(i);
        }
        if(queue.isEmpty()) return new int[0];
        int lecture = 0;
        int courses = numCourses;
        while(!queue.isEmpty()) {
            lecture = queue.poll();
            result[--courses] = lecture;
            preList = map.getOrDefault(lecture, new ArrayList<>());
            for(int pre : preList) {
                count[pre]--;
                if(count[pre] == 0) queue.add(pre);
            }
        }
        return courses == 0 ? result : new int[0];
    }
}