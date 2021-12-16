import java.util.*;

class Solution310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> newList = new ArrayList<>();
        if(n==1) {
            newList.add(0);
            return newList;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge : edges) {
            newList = map.getOrDefault(edge[0], new ArrayList<>());
            newList.add(edge[1]);
            map.put(edge[0], newList);

            newList = map.getOrDefault(edge[1], new ArrayList<>());
            newList.add(edge[0]);
            map.put(edge[1], newList);
        }

        int[] count = new int[n];
        List<Integer> result = new ArrayList<>();

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            count[entry.getKey()] = entry.getValue().size();
            if(entry.getValue().size() == 1) result.add(entry.getKey());
        }

        while( n > 2) {
            n -= result.size();
            List<Integer> changeResult = new ArrayList<>();
            for(int node : result) {
                List<Integer> endPoint = map.get(node);
                for(int end : endPoint) {
                    count[end] --;
                    if(count[end] == 1) changeResult.add(end);
                }
            }
            result = changeResult;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution310 s = new Solution310();
        int[][] edges = new int[][] {{3,0}, {3,1}, {3,2}, {3,4}, {5,4}};
        List<Integer> list = s.findMinHeightTrees(6, edges);
        System.out.println(list.toString());
    }
}