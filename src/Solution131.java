import java.util.ArrayList;
import java.util.List;

class Solution131 {
    public static List<List<String>> result;
    public static int strLength  = 0;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        strLength = s.length();
        dfs(new ArrayList<>(), s);
        return result;
    }

    public void dfs(List<String> beforeList, String str) {
        List<String> re = new ArrayList<>();
        if(str.length() == 0) {
            result.add(new ArrayList<>(beforeList));
            return;
        }
        String s;
        for(int i=0; i< str.length(); i++) {
            s = str.substring(0, i+1);
            if(isPalindrome(s)) {
                beforeList.add(s);
                dfs(beforeList, str.substring(i+1));
                beforeList.remove(beforeList.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution131 s = new Solution131();
        List<List<String>> result = s.partition("aab");
        for(List<String> str : result) {
            System.out.println(str.toString());
        }
    }
}