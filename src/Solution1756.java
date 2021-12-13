class Solution1756 {
    public int countHomogenous(String s) {
        if(s == null || s.length() <= 1) return s.length();
        int MOD = 1000000007;
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[] memo = new int[len];
        memo[0] = 1;
        int count = 1;
        for(int i=1; i<len; i++) {
            if(arr[i-1] == arr[i]) {
                memo[i] = memo[i-1] + 1;
            }else {
                memo[i] = 1;
            }
            if(MOD - memo[i] < count) count = (count + memo[i]) % MOD;
            else count += memo[i];
        }
        return count;
    }

    public static void main(String[] args) {
        Solution1756 s = new Solution1756();
        System.out.println(s.countHomogenous("abbcccaa"));
    }
}