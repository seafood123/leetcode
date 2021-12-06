import java.util.*;

class Solution819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        String regex = "[!?;,;.'\\s]";
        String[] words = paragraph.split(regex);

        Set<String> bannedSet = new HashSet<>();

        for(String str : banned) {
            bannedSet.add(str);
        }

        Map<String, Integer> map = new HashMap<>();
        int now = 0;
        int max = 0;
        String result = "";
        for(String str : words) {
            str = str.toLowerCase(Locale.ROOT);
            if(bannedSet.contains(str) || str.trim().length() == 0) continue;
            now = map.getOrDefault(str, 0);
            map.put(str, now+1);
            if(max < now + 1) {
                max = now + 1;
                result = str;
            }
        }
        System.out.println(map.toString());
        return result;
    }

    public static void main(String[] args) {
        Solution819 solution819 = new Solution819();
        solution819.mostCommonWord("Bob. hIt, ball", new String[] {"bob", "hit"});
    }
}