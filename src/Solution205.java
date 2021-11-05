
import java.util.*;
import java.util.stream.Collectors;

public class Solution205 {
    public static boolean isIsomorphic(String s, String t) {
        Map<String, ArrayList<Integer>> map1 = new LinkedHashMap<>();
        Map<String, ArrayList<Integer>> map2 = new LinkedHashMap<>();

        if(s.length() != t.length()) return false;

        String[] sArr = s.split("");
        String[] tArr = t.split("");

        for(int i=0;i<sArr.length;i++){
            if(!map1.containsKey(sArr[i])) {
                map1.put(sArr[i],new ArrayList<>());
            }
            map1.get(sArr[i]).add(i);
        }
        for(int i=0;i<tArr.length;i++){
            if(!map2.containsKey(tArr[i])) {
                map2.put(tArr[i],new ArrayList<>());
            }
            map2.get(tArr[i]).add(i);
        }

        if(map1.size() != map2.size()) return false;

        List<ArrayList<Integer>> list1 = map1.values().stream().collect(Collectors.toList());
        List<ArrayList<Integer>> list2 = map2.values().stream().collect(Collectors.toList());


        for(int i=0;i<list1.size();i++){
            ArrayList<Integer> s1 = list1.get(i);
            ArrayList<Integer> s2 = list2.get(i);
            if(!s1.equals(s2)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("aaabbbab","bbbaaaab"));
    }
}
