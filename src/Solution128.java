import java.util.HashMap;
import java.util.Map;

class Solution128 {
    public int longestConsecutive(int[] nums) {
        int[] parent = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(nums[i])) continue;
            parent[i] = i;
            map.put(nums[i], i);
        }
        int now = 0;
        for(int i = 0; i< nums.length; i++) {
            now = nums[i];
            if(map.containsKey(now-1) && find(parent, map.get(now-1)) != find(parent, map.get(now))) {
                union(parent, i, map.get(now-1));
            }
            if(map.containsKey(now+1) && find(parent, map.get(now+1)) != find(parent, map.get(now))) {
                union(parent, i, map.get(now+1));
            }
        }

        int[] result = new int[nums.length];
        int root = 0;
        int max = 0;
        for(int i : map.keySet()) {
            root = find(parent, map.get(i));
            result[root] ++;
            max = Math.max(max, result[root]);
        }

//        System.out.println(Arrays.toString(result));
        return max;

    }

    public void union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        parent[rootA] = rootB;
    }

    public int find(int[] parent, int i) {
        if(parent[i] == i) return i;
        return find(parent, parent[i]);
    }

    public static void main(String[] args) {
        Solution128 solution128 = new Solution128();
        solution128.longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1});
    }
}