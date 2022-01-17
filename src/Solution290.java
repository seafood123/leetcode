import java.util.HashMap;
import java.util.Map;

class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        Map<String, String> map = new HashMap<>();
        Map<String, String> reverseMap = new HashMap<>();
        String[] patternArray = pattern.split("");
        String[] arr = s.split(" ");
        if(patternArray.length != arr.length) return false;
        for (int i = 0; i < patternArray.length; i++) {
            if (map.containsKey(patternArray[i])) {
                if (!map.get(patternArray[i]).equals(arr[i])) return false;
            } else if (reverseMap.containsKey(arr[i])) {
                if (!reverseMap.get(arr[i]).equals(patternArray[i])) return false;
            } else {
                map.put(patternArray[i], arr[i]);
                reverseMap.put(arr[i], patternArray[i]);
            }
        }
        return true;
    }
}