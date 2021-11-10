import java.util.HashSet;
import java.util.Set;

class Solution3 {
    public static int lengthOfLongestSubstring(String s) {
//        Input: s = "abcabcbb"
//        Output: 3
        /*# 1
        int len = s.length();
        if(len <= 1) return len;

        int start = 0;
        int end = 0;

        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        while (start < len && end < len) {
            if(start == end) {
                set.add(s.charAt(start));
                end++;
            } else {
                if(set.contains(s.charAt(end))) {
                    maxLen = Math.max(maxLen, set.size());
                    set.remove(s.charAt(start));
                    start++;
                }else {
                    set.add(s.charAt(end));
                    end++;
                }
            }
        }

        return Math.max(maxLen, set.size());*/

        int len = s.length();
        if(len <= 1) return len;

        int start = 0;
        int end = 0;

        int maxLen = 0;

        boolean[] alphabet = new boolean[200];

        while (start < len && end < len) {
            if(start == end) {
                alphabet[s.charAt(start)] = true;
                end++;
            } else {
                if(alphabet[s.charAt(end)]) {
                    maxLen = Math.max(maxLen, end - start);
                    alphabet[s.charAt(start)] = false;
                    start++;
                }else {
                    alphabet[s.charAt(end)] = true;
                    end++;
                }
            }
        }
        return Math.max(maxLen, end - start);
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("au9"));
    }
}