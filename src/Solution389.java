class Solution389 {
    public char findTheDifference(String s, String t) {
        int sSum = 0;
        int tSum = 0;
        
        for(char c : s.toCharArray()) sSum += c;
        for(char c : t.toCharArray()) tSum += c;
        
        return (char) (tSum - sSum);
    }
    public char findTheDifference1(String s, String t) {
        int[] sArr = new int[26];
        int[] tArr = new int[26];
        
        for(int i=0; i< s.length(); i++) {
            sArr[s.charAt(i) - 'a']++;
        }
        int tt = 0;
        for(int i=0; i<t.length(); i++) {
            tt = t.charAt(i) - 'a';
            if(tArr[tt] == sArr[tt]) break;
            tArr[tt]++;
        }
        return (char) (tt+'a');
    }
}