import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        if(arr == null || arr.length <= 1) return result;
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int value = 0;
        List<Integer> list;
        for(int i=0; i<arr.length-1;i++) {
            value = arr[i+1] - arr[i];
            if(min > value) {
                result = new ArrayList<>();
                list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i+1]);
                result.add(list);
            }else if(min == value) {
                list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i+1]);
                result.add(list);
            }
        }
        return result;
    }
}